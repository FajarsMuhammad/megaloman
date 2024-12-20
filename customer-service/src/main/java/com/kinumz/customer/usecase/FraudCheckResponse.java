package com.kinumz.customer.usecase;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FraudCheckResponse {

    boolean isFraudster;

    public static FraudCheckResponse failed(){
        return FraudCheckResponse.builder().isFraudster(false).build();
    }

}
