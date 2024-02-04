package com.flightApi.flightsearch.service;

import com.flightApi.flightsearch.model.Airport;
import com.flightApi.flightsearch.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepository airportRepository;


    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long airportId) {
        return airportRepository.findById(airportId).orElse(null);
    }

    public Airport createAirport(Airport airport) {
        // Ekstra doğrulama veya işlemler eklenebilir
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long airportId, Airport updatedAirport) {
        Airport existingAirport = airportRepository.findById(airportId).orElse(null);

        if (existingAirport != null) {
            // Güncelleme işlemleri
            existingAirport.setCity(updatedAirport.getCity());
            // Diğer alanları da güncelle...
            return airportRepository.save(existingAirport);
        }

        return null; // Belirtilen kimlikle havaalanı bulunamadı
    }

    public void deleteAirport(Long airportId) {
        airportRepository.deleteById(airportId);
    }
}

