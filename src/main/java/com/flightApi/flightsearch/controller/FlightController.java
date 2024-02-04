package com.flightApi.flightsearch.controller;

import com.flightApi.flightsearch.DTO.FlightDTO;
import com.flightApi.flightsearch.model.Flight;
import com.flightApi.flightsearch.service.DtoMapperService;
import com.flightApi.flightsearch.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;
    private final DtoMapperService dtoMapperService;

    public FlightController(FlightService flightService, DtoMapperService dtoMapperService) {
        this.flightService = flightService;
        this.dtoMapperService = dtoMapperService;
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        List<FlightDTO> flightDTOs = flights.stream()
                .map(dtoMapperService::convertToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(flightDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);

        if (flight != null) {
            return ResponseEntity.ok(dtoMapperService.convertToDto(flight));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDTO>> searchFlights(
            @RequestParam("departureAirportId") Long departureAirportId,
            @RequestParam("arrivalAirportId") Long arrivalAirportId,
            @RequestParam("departureDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime,
            @RequestParam(value = "returnDateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDateTime) {

        List<Flight> flights = flightService.searchFlights(departureAirportId, arrivalAirportId, departureDateTime, returnDateTime);
        List<FlightDTO> flightDTOs = flights.stream()
                .map(dtoMapperService::convertToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(flightDTOs);
    }

    @PostMapping("/create")
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO FlightDTO) {
        Flight newFlight = flightService.createFlight(dtoMapperService.convertToEntity(FlightDTO));
        return ResponseEntity.ok(dtoMapperService.convertToDto(newFlight));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable Long id, @RequestBody FlightDTO updatedFlightDTO) {
        Flight updatedFlight = flightService.updateFlight(id, dtoMapperService.convertToEntity(updatedFlightDTO));

        if (updatedFlight != null) {
            return ResponseEntity.ok(dtoMapperService.convertToDto(updatedFlight));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}

