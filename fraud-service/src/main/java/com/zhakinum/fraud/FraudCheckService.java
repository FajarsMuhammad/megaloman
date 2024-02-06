package com.zhakinum.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryJpaRepository fraudCheckHistoryJpaRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryJpaRepository.save(
            FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .build()
        );
        return false;
    }

}
