package com.kinumz.fraud;

import java.time.LocalDateTime;
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
                .createdAt(LocalDateTime.now())
                .build()
        );
        return false;
    }

}
