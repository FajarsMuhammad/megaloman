package com.kinumz.security.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kinumz.security.dto.request.SignUpRequest;
import com.kinumz.security.dto.request.SigninRequest;
import com.kinumz.security.dto.response.JwtAuthenticationResponse;
import com.kinumz.security.model.Role;
import com.kinumz.security.model.User;
import com.kinumz.security.repository.UserRepository;
import com.kinumz.security.service.AuthenticationService;
import com.kinumz.security.service.JwtService;

import lombok.RequiredArgsConstructor;

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
    var jwt = jwtService.generateToken(user);
    return JwtAuthenticationResponse.builder().token(jwt).build();
  }

  @Override
  public JwtAuthenticationResponse signin(SigninRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    var user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
    var jwt = jwtService.generateToken(user);

    return JwtAuthenticationResponse.builder()
        .token(jwt)
        .username(user.getUsername())
        .name(user.getName()).build();
  }
}
