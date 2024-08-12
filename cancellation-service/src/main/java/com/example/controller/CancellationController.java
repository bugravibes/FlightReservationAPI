package com.example.controller;

import com.example.model.ReservationCancellationRequest;
import com.example.model.ReservationCancellationResponse;
import com.example.service.CancellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CancellationController {

    @Autowired
    private CancellationService cancellationService;

    @PostMapping("/cancellation")
    public ReservationCancellationResponse cancelReservation(@RequestBody ReservationCancellationRequest request) {
        return cancellationService.cancelReservation(request);
    }
}
