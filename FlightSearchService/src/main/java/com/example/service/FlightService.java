package com.example.service;

import com.example.client.AuthClient;
import com.example.dao.FlightDao;
import com.example.entity.Flight;
import com.example.entity.FlightSearchRequest;
import com.example.entity.FlightSearchResponse;
import com.example.entity.FlightSearchResponse.FlightDetails;
import com.example.entity.FlightSearchResponse.Location;
import com.example.entity.FlightSearchResponse.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private AuthClient authClient;

    @Autowired
    private FlightDao flightDao;

    public FlightSearchResponse searchFlights(String clientId, String clientPassword, FlightSearchRequest.SearchRequest request) {
        boolean isAuthenticated = authClient.authenticate(clientId, clientPassword);
        if (!isAuthenticated) {
            return null;
        }

        List<Flight> flights = flightDao.findFlights(request);
        List<FlightDetails> flightDetails = flights.stream().map(flight -> {
            FlightDetails details = new FlightDetails();
            details.setFlightNumber(flight.getFlightNumber());
            details.setAirline(flight.getAirline());

            Location departure = new Location();
            departure.setAirport(flight.getDepartureAirport());
            departure.setCity(flight.getDepartureCity());
            departure.setTime(flight.getDepartureTime().toString());
            details.setDeparture(departure);

            Location arrival = new Location();
            arrival.setAirport(flight.getArrivalAirport());
            arrival.setCity(flight.getArrivalCity());
            arrival.setTime(flight.getArrivalTime().toString());
            details.setArrival(arrival);

            details.setDuration(flight.getDuration());

            Price price = new Price();
            price.setCurrency("USD"); // Assuming currency is always USD
            price.setAmount(flight.getPrice());
            details.setPrice(price);

            details.setFlightClass(flight.getFlightClass());
            details.setAvailability(flight.getAvailability());

            return details;
        }).collect(Collectors.toList());

        FlightSearchResponse response = new FlightSearchResponse();
        response.setFlights(flightDetails);
        return response;
    }


}
