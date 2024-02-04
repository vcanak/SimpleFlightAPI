package com.flightApi.flightsearch.service;

import com.flightApi.flightsearch.DTO.AirportDTO;
import com.flightApi.flightsearch.DTO.FlightDTO;
import com.flightApi.flightsearch.model.Airport;
import com.flightApi.flightsearch.model.Flight;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DtoMapperService {
    private final ModelMapper modelMapper;

    // Constructor
    public DtoMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FlightDTO convertToDto(Flight flight) {
        return new FlightDTO(
                flight.getId(),
                convertToDto(flight.getDepartureAirport()),
                convertToDto(flight.getArrivalAirport()),
                flight.getDepartureDateTime(),
                flight.getReturnDateTime(),
                flight.getPrice()
        );
    }

    public AirportDTO convertToDto(Airport airport) {
        return new AirportDTO(airport.getCity());
    }

    public Flight convertToEntity(FlightDTO flightDTO) {
        return modelMapper.map(flightDTO, Flight.class);
    }

    public Airport convertToEntity(AirportDTO airportDTO) {
        return modelMapper.map(airportDTO, Airport.class);
    }
}

