package com.example.service;

import com.example.entity.ContactInfoEntity;
import com.example.entity.FlightEntity;
import com.example.entity.PassengerEntity;
import com.example.entity.ReservationEntity;
import com.example.entity.TicketEntity;
import com.example.model.ReservationSearchRequest;
import com.example.model.ReservationSearchResponse;
import com.example.repository.ContactInfoRepository;
import com.example.repository.FlightRepository;
import com.example.repository.PassengerRepository;
import com.example.repository.ReservationRepository;
import com.example.repository.TicketRepository;
import com.example.repository.PassengerTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationSearchServiceImpl implements ReservationSearchService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PassengerTicketRepository passengerTicketRepository;

    @Override
    public ReservationSearchResponse searchReservation(ReservationSearchRequest request) {
        String reservationId = request.getReservationInfoRequest().getReservationId();
        ReservationEntity reservation = reservationRepository.findByReservationId(reservationId);

        FlightEntity flightEntity = flightRepository.findById(reservation.getFlightNumber()).orElse(null);
        List<PassengerEntity> passengerEntities = passengerRepository.findByReservationPassengers_ReservationId(reservation.getId());
        ContactInfoEntity contactInfoEntity = contactInfoRepository.findByPassengerId(reservation.getId());
        List<TicketEntity> tickets = ticketRepository.findByReservation_Id(reservation.getId());

        ReservationSearchResponse.ReservationInfoResponse reservationInfoResponse = new ReservationSearchResponse.ReservationInfoResponse();
        reservationInfoResponse.setReservationId(reservation.getReservationId());
        reservationInfoResponse.setStatus(reservation.getStatus());

        ReservationSearchResponse.Flight flight = new ReservationSearchResponse.Flight();
        if (flightEntity != null) {
            flight.setFlight_number(flightEntity.getFlightNumber());
            flight.setAirline(flightEntity.getAirline());
            flight.setDeparture(
                    new ReservationSearchResponse.Flight.Departure(flightEntity.getDepartureAirport(), flightEntity.getDepartureCity(), flightEntity.getDepartureTime())
            );
            flight.setArrival(new ReservationSearchResponse.Flight.Arrival(flightEntity.getArrivalAirport(), flightEntity.getArrivalCity(), flightEntity.getArrivalTime()));
            flight.setFlightClass(flightEntity.getFlightClass());
        }
        reservationInfoResponse.setFlight(flight);

        List<ReservationSearchResponse.Passenger> passengers = passengerEntities.stream().map(passenger -> {
            ReservationSearchResponse.Passenger passengerDto = new ReservationSearchResponse.Passenger();
            passengerDto.setFirstName(passenger.getFirstName());
            passengerDto.setLastName(passenger.getLastName());
            passengerDto.setDob(passenger.getDob());
            passengerDto.setPassportNumber(passenger.getPassportNumber());
            passengerDto.setNationality(passenger.getNationality());
            passengerDto.setTicketNumber(tickets.stream()
                    .filter(ticket -> ticket.getPassengerId().equals(passenger.getId()))
                    .findFirst()
                    .map(TicketEntity::getTicketNumber)
                    .orElse(null));
            return passengerDto;
        }).collect(Collectors.toList());
        reservationInfoResponse.setPassengers(passengers);

        if (!tickets.isEmpty()) {
            TicketEntity ticket = tickets.get(0);
            ReservationSearchResponse.Payment payment = new ReservationSearchResponse.Payment();
            payment.setMethod(ticket.getMethod());
            payment.setAmount(ticket.getAmount());
            payment.setCurrency(ticket.getCurrency());
            payment.setTransactionId(ticket.getTransactionId());
            reservationInfoResponse.setPayment(payment);
        }

        ReservationSearchResponse.ContactInfo contactInfo = new ReservationSearchResponse.ContactInfo();
        contactInfo.setEmail(contactInfoEntity.getEmail());
        contactInfo.setPhone(contactInfoEntity.getPhone());
        reservationInfoResponse.setContactInfo(contactInfo);

        ReservationSearchResponse response = new ReservationSearchResponse();
        response.setReservationInfoResponse(reservationInfoResponse);

        return response;
    }
}
