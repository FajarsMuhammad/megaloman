package com.kinumz.customer.client;

import com.kinumz.customer.usecase.FraudCheckResponse;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FraudClientFallback implements FraudClient {

    @Override
    public FraudCheckResponse isFraudSter(Integer customerId) {
        throw new NotFoundException("server busy " + customerId);
    }
}