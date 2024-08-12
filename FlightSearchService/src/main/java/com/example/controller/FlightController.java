package com.example.controller;

import com.example.entity.FlightSearchRequest;
import com.example.entity.FlightSearchResponse;
import com.example.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/search")
    public ResponseEntity<?> searchFlights(@RequestBody FlightSearchRequest request) {
        if (request == null || request.getSearchRequest() == null) {
            return ResponseEntity.badRequest().body("Invalid search request");
        }

        FlightSearchRequest.SearchRequest searchRequest = request.getSearchRequest();
        FlightSearchResponse response = flightService.searchFlights(
                searchRequest.getClientId(),
                searchRequest.getClientPassword(),
                searchRequest);

        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }
}
