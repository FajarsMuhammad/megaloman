package com.kinumz.customer;

import com.kinumz.customer.client.FraudClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerJpaRepository customerJpaRepository;

    //private final RestTemplate restTemplate;

    private final FraudClient fraudClient;

    private final CustomerProducer customerProducer;


    public void registrationCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();

        customerJpaRepository.saveAndFlush(customer);

//        FraudCheckResponse response = restTemplate.getForObject(
//            "http://localhost:8081/api/v1/fraud-check/{customerId}",
//            FraudCheckResponse.class, customer.getId()
//        );

        var response = fraudClient.isFraudSter(customer.getId());

        if (response.isFraudster()) {
            throw new IllegalArgumentException("Not Fraudster");
        }

//        customerProducer.sendMessage(
//            new CustomerEvent(customer.getId(), customer.getFirstName())
//        );

    }
}
