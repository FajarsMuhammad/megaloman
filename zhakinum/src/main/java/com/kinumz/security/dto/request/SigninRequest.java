package com.kinumz.security.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SigninRequest {

    String username;

    String password;

}
