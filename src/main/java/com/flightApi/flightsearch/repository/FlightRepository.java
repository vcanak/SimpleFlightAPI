package com.flightApi.flightsearch.repository;

import com.flightApi.flightsearch.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByDepartureAirportIdAndArrivalAirportIdAndDepartureDateTime(Long departureAirportId, Long arrivalAirportId, LocalDateTime departureDateTime);
    // Ek özel sorgular eklenebilir
}

