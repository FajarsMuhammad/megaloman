package com.kinumz.auth.service;


import com.kinumz.auth.dto.request.SignUpRequest;
import com.kinumz.auth.dto.request.SigninRequest;
import com.kinumz.auth.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
