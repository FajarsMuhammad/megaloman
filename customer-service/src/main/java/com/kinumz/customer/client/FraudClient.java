package com.kinumz.customer.client;

import com.kinumz.customer.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fraud-service", url = "${application.config.fraud-url}")
public interface FraudClient {

    @GetMapping("/{customerId}")
    FraudCheckResponse isFraudSter(@PathVariable Integer customerId);

}
