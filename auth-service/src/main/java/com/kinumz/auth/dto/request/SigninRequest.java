package com.kinumz.auth.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SigninRequest {

    String username;

    String password;

}
