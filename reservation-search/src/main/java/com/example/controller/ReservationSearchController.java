package com.example.controller;

import com.example.model.ReservationSearchRequest;
import com.example.model.ReservationSearchResponse;
import com.example.service.ReservationSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReservationSearchController {

    @Autowired
    private ReservationSearchService reservationSearchService;

    @PostMapping("/reservation-search")
    public ReservationSearchResponse searchReservation(@RequestBody ReservationSearchRequest request) {
        return reservationSearchService.searchReservation(request);
    }
}
