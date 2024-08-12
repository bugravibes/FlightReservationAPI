package com.example.dao;

import com.example.entity.Flight;
import com.example.entity.FlightSearchRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class FlightDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Flight> findFlights(FlightSearchRequest.SearchRequest request) {
        String jpql = "SELECT f FROM Flight f WHERE f.departureAirport = :departureAirport AND f.arrivalAirport = :arrivalAirport AND f.departureTime >= :departureDate";
        TypedQuery<Flight> query = entityManager.createQuery(jpql, Flight.class);
        query.setParameter("departureAirport", request.getDeparture().getAirport());
        query.setParameter("arrivalAirport", request.getArrival().getAirport());
        query.setParameter("departureDate", Timestamp.valueOf(request.getDepartureDate() + " 00:00:00"));
        return query.getResultList();
    }

}
