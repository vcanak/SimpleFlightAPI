package com.flightApi.flightsearch.model;

import jakarta.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city", nullable = false)
    private String city;

    public Airport(String city) {
        this.city = city;
    }
    // Getter and Setter methods

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport airport)) return false;
        return id.equals(airport.id) && getCity().equals(airport.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getCity());
    }
}

