package com.flightApi.flightsearch.service.Interface;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTAuth {

    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
}
