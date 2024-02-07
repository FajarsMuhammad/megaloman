package com.kinumz.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryJpaRepository extends JpaRepository<FraudCheckHistory, Integer> {

}
