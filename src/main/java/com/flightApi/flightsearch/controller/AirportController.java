package com.flightApi.flightsearch.controller;

import com.flightApi.flightsearch.DTO.AirportDTO;
import com.flightApi.flightsearch.model.Airport;
import com.flightApi.flightsearch.service.AirportService;
import com.flightApi.flightsearch.service.DtoMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;
    private final DtoMapperService dtoMapperService;

    public AirportController(AirportService airportService, DtoMapperService dtoMapperService) {
        this.airportService = airportService;
        this.dtoMapperService = dtoMapperService;
    }

    @GetMapping
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
        List<Airport> airports = airportService.getAllAirports();
        List<AirportDTO> airportDTOs = airports.stream()
                .map(dtoMapperService::convertToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(airportDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable Long id) {
        Airport airport = airportService.getAirportById(id);

        if (airport != null) {
            return ResponseEntity.ok(dtoMapperService.convertToDto(airport));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AirportDTO> createAirport(@RequestBody AirportDTO airportDTO) {
        Airport newAirport = airportService.createAirport(dtoMapperService.convertToEntity(airportDTO));
        return ResponseEntity.ok(dtoMapperService.convertToDto(newAirport));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable Long id, @RequestBody AirportDTO updatedAirportDTO) {
        Airport updatedAirport = airportService.updateAirport(id, dtoMapperService.convertToEntity(updatedAirportDTO));

        if (updatedAirport != null) {
            return ResponseEntity.ok(dtoMapperService.convertToDto(updatedAirport));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}

