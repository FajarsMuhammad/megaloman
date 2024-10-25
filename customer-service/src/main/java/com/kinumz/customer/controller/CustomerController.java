package com.kinumz.customer.controller;

import com.kinumz.customer.usecase.CustomerRegistrationRequest;
import com.kinumz.customer.usecase.CustomerRegistrationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRegistrationUseCase customerRegistrationUseCase;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest){
        customerRegistrationUseCase.registrationCustomer(customerRequest);
        log.info("new customer registration {}", customerRequest);

    }

}
