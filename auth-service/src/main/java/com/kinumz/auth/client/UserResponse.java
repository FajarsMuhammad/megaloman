package com.kinumz.auth.client;

import lombok.Value;

@Value
public class UserResponse {

    Long id;
    String username;
    String role;
}
