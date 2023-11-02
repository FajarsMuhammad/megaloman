package com.kinumz.security.service;

import com.kinumz.security.dao.request.SignUpRequest;
import com.kinumz.security.dao.request.SigninRequest;
import com.kinumz.security.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
