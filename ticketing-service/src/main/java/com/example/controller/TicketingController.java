package com.example.controller;

import com.example.model.FlightTicketingRequest;
import com.example.model.FlightTicketingResponse;
import com.example.service.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class TicketingController {

    @Autowired
    private TicketingService ticketingService;

    @PostMapping("/ticket")
    public ResponseEntity<FlightTicketingResponse> ticketReservation(@RequestBody FlightTicketingRequest request) {
        FlightTicketingResponse response = ticketingService.ticketReservation(request);
        return ResponseEntity.ok(response);
    }
}
