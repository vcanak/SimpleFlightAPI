package com.flightApi.flightsearch.controller;


import com.flightApi.flightsearch.DTO.SignUpUser;
import com.flightApi.flightsearch.model.User;
import com.flightApi.flightsearch.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpUser signUpUser){
        return ResponseEntity.ok(authenticationService.signUp(signUpUser));
    }

}
