package com.example.service;


import com.example.model.FlightTicketingRequest;
import com.example.model.FlightTicketingResponse;
import org.springframework.stereotype.Service;

public interface TicketingService {
    FlightTicketingResponse ticketReservation(FlightTicketingRequest request);
}
