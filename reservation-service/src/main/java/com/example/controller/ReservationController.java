package com.example.controller;

import com.example.model.FlightReservationRequest;
import com.example.model.FlightReservationResponse;
import com.example.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FlightReservationResponse createReservation(@RequestBody FlightReservationRequest request) {
        System.out.println("Received POST /create request");
        return reservationService.reserveFlight(request.getReservationRequest().getClientId(),
                request.getReservationRequest().getClientPassword(),
                request.getReservationRequest());
    }
}
