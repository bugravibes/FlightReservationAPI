package com.example.service;

import com.example.entity.ContactInfoEntity;
import com.example.entity.FlightEntity;
import com.example.entity.PassengerEntity;
import com.example.entity.ReservationEntity;
import com.example.model.*;
import com.example.repository.ContactInfoRepository;
import com.example.repository.FlightRepository;
import com.example.repository.PassengerRepository;
import com.example.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;

@Service
public class TicketingServiceImpl implements TicketingService {

    private static final Logger logger = Logger.getLogger(TicketingServiceImpl.class.getName());

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @Override
    public FlightTicketingResponse ticketReservation(FlightTicketingRequest request) {
        logger.info("Received ticket reservation request: " + request);

        if (request == null || request.getTicketingRequest() == null) {
            logger.severe("Invalid request: request or ticketingRequest is null");
            throw new IllegalArgumentException("Invalid request");
        }

        FlightTicketingRequest.TicketingRequest ticketingRequest = request.getTicketingRequest();
        logger.info("Processing ticketing request: " + ticketingRequest);

        // Fetch the reservation
        String reservationId = ticketingRequest.getReservationId();
        ReservationEntity reservation = reservationRepository.findByReservationId(reservationId);

        logger.info("Fetched reservation: " + reservation);

        if (!"OP".equals(reservation.getStatus())) {
            logger.info("Reservation is not in 'OP' status, current status: " + reservation.getStatus());
            throw new RuntimeException("Reservation is not in 'OP' status");
        }

        // Fetch flight details
        FlightEntity flightEntity = flightRepository.findById(reservation.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        logger.info("Fetched flight details: " + flightEntity);

        // Fetch passenger details
        List<PassengerEntity> passengerEntities = passengerRepository.findByReservationPassengers_Reservation_Id(reservation.getId());

        logger.info("Fetched passenger details: " + passengerEntities);

        // Fetch contact info
        ContactInfoEntity contactInfoEntity = contactInfoRepository.findByReservation_Id(reservation.getId());

        logger.info("Fetched contact info: " + contactInfoEntity);

        // Process payment confirmation
        Payment payment = new Payment();
        payment.setTransaction_id(ticketingRequest.getPaymentConfirmation().getTransactionId());
        payment.setAmount(ticketingRequest.getPaymentConfirmation().getAmount());
        payment.setCurrency(ticketingRequest.getPaymentConfirmation().getCurrency());
        payment.setMethod(ticketingRequest.getPaymentConfirmation().getPaymentMethod());

        logger.info("Processed payment: " + payment);

        // Update reservation status to 'TK'
        reservation.setStatus("TK");
        reservationRepository.save(reservation);

        logger.info("Updated reservation status to 'TK'");

        // Build response
        FlightTicketingResponse response = new FlightTicketingResponse();
        FlightTicketingResponse.TicketingResponse response1 = new FlightTicketingResponse.TicketingResponse();
        response1.setReservationId(reservation.getReservationId());
        response1.setStatus("ticketed");
        response1.setFlight(flightEntity.toFlightDto());
        response1.setPassengers(passengerEntities.stream().map(PassengerEntity::toPassengerDto).collect(Collectors.toList()));
        response1.setPayment(payment);
        response1.setContactInfo(contactInfoEntity.toContactInfoDto());
        response.setTicketingResponse(response1);

        logger.info("Built response: " + response);

        return response;
    }
}
