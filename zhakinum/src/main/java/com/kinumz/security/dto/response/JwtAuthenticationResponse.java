package com.kinumz.security.dto.response;

import lombok.*;

@Value
@Builder
@AllArgsConstructor
public class JwtAuthenticationResponse {

    String token;
    String username;
    String name;
}
