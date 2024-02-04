package com.flightApi.flightsearch.service;

import com.flightApi.flightsearch.model.Flight;
import com.flightApi.flightsearch.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        // Uygun uçuşları arama işlemleri burada gerçekleştirilir
        // Örneğin, repository sınıfındaki özel sorgular kullanılabilir
        // ...
        List<Flight> flightList = new ArrayList<>();

        flightList.add(flightRepository.findByDepartureAirportIdAndArrivalAirportIdAndDepartureDateTime(
                departureAirportId, arrivalAirportId, departureDateTime));
        if(returnDateTime != null){
            flightList.add(flightRepository.findByDepartureAirportIdAndArrivalAirportIdAndDepartureDateTime(
                    departureAirportId, arrivalAirportId, returnDateTime));

        }
        return flightList;
    }

    public Flight createFlight(Flight flight) {
        // Ekstra doğrulama veya işlemler eklenebilir
        return flightRepository.save(flight);
    }
    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long flightId) {
        return flightRepository.findById(flightId).orElse(null);
    }


    public Flight updateFlight(Long flightId, Flight updatedFlight) {
        Flight existingAirport = flightRepository.findById(flightId).orElse(null);

        if (existingAirport != null) {
            // Güncelleme işlemleri
            existingAirport.setArrivalAirport(updatedFlight.getArrivalAirport());
            existingAirport.setDepartureAirport(updatedFlight.getDepartureAirport());
            existingAirport.setPrice(updatedFlight.getPrice());
            existingAirport.setDepartureDateTime(updatedFlight.getDepartureDateTime());

            // Diğer alanları da güncelle...
            return flightRepository.save(existingAirport);
        }

        return null; // Belirtilen kimlikle havaalanı bulunamadı
    }
}

