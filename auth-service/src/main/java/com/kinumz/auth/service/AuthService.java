package com.kinumz.auth.service;

import com.kinumz.auth.client.UserClient;
import com.kinumz.auth.dto.request.SignUpRequest;
import com.kinumz.auth.dto.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final UserClient userClient;

    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = userClient.getUser(request.getUsername());
        var jwt = jwtUtil.generateToken(user, "ACCESS");
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
