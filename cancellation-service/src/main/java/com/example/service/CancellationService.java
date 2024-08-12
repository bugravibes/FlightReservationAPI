package com.example.service;

import com.example.model.ReservationCancellationRequest;
import com.example.model.ReservationCancellationResponse;

public interface CancellationService {
    ReservationCancellationResponse cancelReservation(ReservationCancellationRequest request);
}
