package com.flightApi.flightsearch.service;

import com.flightApi.flightsearch.DTO.SignUpUser;
import com.flightApi.flightsearch.model.Role;
import com.flightApi.flightsearch.model.User;
import com.flightApi.flightsearch.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(SignUpUser signUpUser){
        User user = new User();
        user.setEmail(signUpUser.getEmail());
        user.setFirstName(signUpUser.getFirstName());
        user.setLastName(signUpUser.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpUser.getPassword()));

        return userRepository.save(user);
    }
}
