package com.kinumz.security.service;

import com.kinumz.security.dto.request.SignUpRequest;
import com.kinumz.security.dto.request.SigninRequest;
import com.kinumz.security.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
