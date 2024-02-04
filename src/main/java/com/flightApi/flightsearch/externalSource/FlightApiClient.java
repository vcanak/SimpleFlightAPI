package com.flightApi.flightsearch.externalSource;

import com.flightApi.flightsearch.model.Flight;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;

@Component
public class FlightApiClient {

    private static final String API_URL = "https://api.example.com/flights";

    private final RestTemplate restTemplate;

    public FlightApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to make API call and retrieve flight information
    public Flight[] getFlights() {

        System.out.println("Third Party API is called");
       // return restTemplate.getForObject(API_URL, Flight[].class);
        return null;
    }
}

