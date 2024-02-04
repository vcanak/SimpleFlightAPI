package com.flightApi.flightsearch.externalSource;

import com.flightApi.flightsearch.model.Flight;
import com.flightApi.flightsearch.service.FlightService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class FlightScheduler {

    private final FlightApiClient flightApiClient;
    private final FlightService flightService;

    public FlightScheduler(FlightApiClient flightApiClient, FlightService flightService) {
        this.flightApiClient = flightApiClient;
        this.flightService = flightService;
    }

    @Scheduled(cron = "0 * * * * *") // Run daily at 1:00 AM
    public void fetchAndSaveFlights() {
        Flight[] flights = flightApiClient.getFlights();

        /*for (Flight flight : flights) {
            flightService.createFlight(flight);
        }*/
    }
}
