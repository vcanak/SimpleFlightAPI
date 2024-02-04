package com.flightApi.flightsearch.DTO;

public class AirportDTO {
    private Long id;
    private String city;

    // Constructor
    public AirportDTO(String city) {
        this.city = city;
    }

    // Getter methods


    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
