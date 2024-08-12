package com.example.service;

import com.example.model.*;
import com.example.entity.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    private BillingAddressRepository billingAddressRepository;

    @Autowired
    private ReservationPassengerRepository reservationPassengerRepository;

    public FlightReservationResponse reserveFlight(String clientId, String clientPassword, FlightReservationRequest.ReservationRequest request) {
        FlightReservationResponse response = new FlightReservationResponse();
        String reservationId = "RES" + UUID.randomUUID().toString().replace("-", "");
        response.getReservationResponse().setReservationId(reservationId);
        response.getReservationResponse().setStatus("confirmed");

        ContactInfo contactInfoRequest = request.getContactInfo();
        ContactInfoEntity contactInfoEntity = new ContactInfoEntity();
        mapToContactInfoEntity(contactInfoRequest, contactInfoEntity);
        contactInfoRepository.save(contactInfoEntity);

        FlightReservationRequest.ReservationRequest.Payment paymentRequest = request.getPayment();
        BillingAddressEntity billingAddressEntity = new BillingAddressEntity();
        mapToBillingAddressEntity(paymentRequest.getDetails().getBillingAddress(), billingAddressEntity);
        billingAddressRepository.save(billingAddressEntity);

        PaymentDetailsEntity paymentDetailsEntity = new PaymentDetailsEntity();
        mapToPaymentDetailsEntity(paymentRequest, paymentDetailsEntity);
        paymentDetailsEntity.setBillingAddress(billingAddressEntity);
        paymentDetailsRepository.save(paymentDetailsEntity);

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setReservationId(reservationId);
        reservationEntity.setClientId(request.getClientId());
        reservationEntity.setFlightId(flightRepository.findByFlightNumber(request.getFlight().getFlight_number()).getFlightNumber());
        reservationEntity.setPaymentDetails(paymentDetailsEntity);
        reservationEntity.setContactInfo(contactInfoEntity);
        reservationEntity.setStatus("OP");
        reservationRepository.save(reservationEntity);

        List<FlightReservationRequest.ReservationRequest.Passenger> passengers = request.getPassengers();
        for (FlightReservationRequest.ReservationRequest.Passenger passenger : passengers) {
            PassengerEntity passengerEntity = new PassengerEntity();
            mapToPassengerEntity(passenger, passengerEntity);

            ContactInfoEntity passengerContactInfoEntity = new ContactInfoEntity();
            mapToContactInfoEntity(passenger.getContactInfo(), passengerContactInfoEntity);
            contactInfoRepository.save(passengerContactInfoEntity);

            passengerEntity.setContactInfo(passengerContactInfoEntity);
            passengerRepository.save(passengerEntity);

            ReservationPassengerEntity reservationPassengerEntity = new ReservationPassengerEntity();
            ReservationPassengerId reservationPassengerId = new ReservationPassengerId();
            reservationPassengerId.setReservationId(reservationEntity.getId());
            reservationPassengerId.setPassengerId(passengerEntity.getId());
            reservationPassengerEntity.setId(reservationPassengerId);
            reservationPassengerEntity.setReservation(reservationEntity);
            reservationPassengerEntity.setPassenger(passengerEntity);
            reservationPassengerRepository.save(reservationPassengerEntity);
            System.out.println("Passenger ID: " + passengerEntity.getId());
        }
        System.out.println("Reservation ID: " + reservationEntity.getId());

        FlightReservationResponse.ReservationResponse.Flight flightResponse = new FlightReservationResponse.ReservationResponse.Flight();
        FlightEntity flightEntity = flightRepository.findByFlightNumber(request.getFlight().getFlight_number());
        flightResponse.setFlight_number(flightEntity.getFlightNumber());
        flightResponse.setAirline(flightEntity.getAirline());
        flightResponse.setDeparture(mapToDepartureResponse(flightEntity));
        flightResponse.setArrival(mapToArrivalResponse(flightEntity));
        flightResponse.setFlightClass(flightEntity.getFlightClass());

        response.getReservationResponse().setFlight(flightResponse);

        List<FlightReservationResponse.ReservationResponse.Passenger> responsePassengers = passengers.stream()
                .map(this::mapToPassengerResponse)
                .collect(Collectors.toList());
        response.getReservationResponse().setPassengers(responsePassengers);

        return response;
    }

    private FlightReservationResponse.ReservationResponse.Flight.Departure mapToDepartureResponse(FlightEntity flightEntity) {
        FlightReservationResponse.ReservationResponse.Flight.Departure departureResponse = new FlightReservationResponse.ReservationResponse.Flight.Departure();
        departureResponse.setAirport(flightEntity.getDepartureAirport());
        departureResponse.setCity(flightEntity.getDepartureCity());
        departureResponse.setTime(flightEntity.getDepartureTime());
        return departureResponse;
    }

    private FlightReservationResponse.ReservationResponse.Flight.Arrival mapToArrivalResponse(FlightEntity flightEntity) {
        FlightReservationResponse.ReservationResponse.Flight.Arrival arrivalResponse = new FlightReservationResponse.ReservationResponse.Flight.Arrival();
        arrivalResponse.setAirport(flightEntity.getArrivalAirport());
        arrivalResponse.setCity(flightEntity.getArrivalCity());
        arrivalResponse.setTime(flightEntity.getArrivalTime());
        return arrivalResponse;
    }

    private void mapToPassengerEntity(FlightReservationRequest.ReservationRequest.Passenger passenger, PassengerEntity passengerEntity) {
        passengerEntity.setFirstName(passenger.getFirstName());
        passengerEntity.setLastName(passenger.getLastName());
        passengerEntity.setDob(passenger.getDob());
        passengerEntity.setPassportNumber(passenger.getPassportNumber());
        passengerEntity.setNationality(passenger.getNationality());

    }

    private void mapToContactInfoEntity(ContactInfo contactInfo, ContactInfoEntity contactInfoEntity) {
        contactInfoEntity.setEmail(contactInfo.getEmail());
        contactInfoEntity.setPhone(contactInfo.getPhone());
    }

    private void mapToPaymentDetailsEntity(FlightReservationRequest.ReservationRequest.Payment payment, PaymentDetailsEntity paymentDetailsEntity) {
        paymentDetailsEntity.setMethod(payment.getMethod());
        paymentDetailsEntity.setCardNumber(payment.getDetails().getCardNumber());
        paymentDetailsEntity.setExpiryDate(payment.getDetails().getExpiryDate());
        paymentDetailsEntity.setCvv(payment.getDetails().getCvv());
        paymentDetailsEntity.setCardholderName(payment.getDetails().getCardholderName());
    }

    private void mapToBillingAddressEntity(FlightReservationRequest.ReservationRequest.Payment.Details.BillingAddress billingAddress, BillingAddressEntity billingAddressEntity) {
        billingAddressEntity.setStreet(billingAddress.getStreet());
        billingAddressEntity.setCity(billingAddress.getCity());
        billingAddressEntity.setState(billingAddress.getState());
        billingAddressEntity.setPostalCode(billingAddress.getPostalCode());
        billingAddressEntity.setCountry(billingAddress.getCountry());
    }

    private FlightReservationResponse.ReservationResponse.Passenger mapToPassengerResponse(FlightReservationRequest.ReservationRequest.Passenger passenger) {
        FlightReservationResponse.ReservationResponse.Passenger passengerResponse = new FlightReservationResponse.ReservationResponse.Passenger();
        passengerResponse.setFirstName(passenger.getFirstName());
        passengerResponse.setLastName(passenger.getLastName());
        passengerResponse.setDob(passenger.getDob());
        passengerResponse.setPassportNumber(passenger.getPassportNumber());
        passengerResponse.setNationality(passenger.getNationality());
        passengerResponse.setContactInfo(mapToContactInfoResponse(passenger.getContactInfo()));
        return passengerResponse;
    }

    private ContactInfo mapToContactInfoResponse(ContactInfo contactInfo) {
        ContactInfo contactInfoResponse = new ContactInfo();
        contactInfoResponse.setEmail(contactInfo.getEmail());
        contactInfoResponse.setPhone(contactInfo.getPhone());
        return contactInfoResponse;
    }
}
