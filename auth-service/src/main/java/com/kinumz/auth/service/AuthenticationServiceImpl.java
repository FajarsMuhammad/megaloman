package com.kinumz.auth.service;

import com.kinumz.auth.dto.request.SignUpRequest;
import com.kinumz.auth.dto.request.SigninRequest;
import com.kinumz.auth.dto.response.JwtAuthenticationResponse;
import com.kinumz.auth.model.CustomUserDetails;
import com.kinumz.auth.model.Role;
import com.kinumz.auth.model.User;
import com.kinumz.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().name(request.getName())
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
        userRepository.save(user.withCreatedBy(request.getUsername()));
        var jwt = jwtService.generateToken(new CustomUserDetails(user));
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        Authentication authenticate = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if (authenticate.isAuthenticated()) {
            User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
            var jwt = jwtService.generateToken(new CustomUserDetails(user));

            return JwtAuthenticationResponse.builder()
                .token(jwt)
                .username(user.getUsername())
                .name(user.getName()).build();
        }
        return JwtAuthenticationResponse.failed();
    }
}
