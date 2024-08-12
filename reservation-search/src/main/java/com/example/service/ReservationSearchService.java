package com.example.service;

import com.example.model.ReservationSearchRequest;
import com.example.model.ReservationSearchResponse;

public interface ReservationSearchService {
    ReservationSearchResponse searchReservation(ReservationSearchRequest request);
}
