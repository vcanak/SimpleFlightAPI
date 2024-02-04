package com.flightApi.flightsearch.repository;

import com.flightApi.flightsearch.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    // Ek özel sorgular eklenebilir
}

