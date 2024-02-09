package com.kinumz.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class JwtAuthenticationResponse {

    String token;
    String username;
    String name;
}
