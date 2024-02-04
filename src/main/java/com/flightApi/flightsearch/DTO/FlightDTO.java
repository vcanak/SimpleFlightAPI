package com.flightApi.flightsearch.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightDTO {
    private Long id;
    private AirportDTO departureAirport;
    private AirportDTO arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime returnDateTime;
    private BigDecimal price;

    // Constructor
    public FlightDTO(Long id, AirportDTO departureAirport, AirportDTO arrivalAirport,
                     LocalDateTime departureDateTime, LocalDateTime returnDateTime, BigDecimal price) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateTime = departureDateTime;
        this.returnDateTime = returnDateTime;
        this.price = price;
    }

    // Getter methods

    public AirportDTO getDepartureAirport() {
        return departureAirport;
    }

    public AirportDTO getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

