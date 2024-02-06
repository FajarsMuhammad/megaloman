package com.zhakinum.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerJpaRepository customerJpaRepository) {

    public void registrationCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();

        customerJpaRepository.save(customer);
    }
}
