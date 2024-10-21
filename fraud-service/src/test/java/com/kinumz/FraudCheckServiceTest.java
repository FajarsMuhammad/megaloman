package com.kinumz;

import com.kinumz.fraud.FraudCheckHistoryJpaRepository;
import com.kinumz.fraud.FraudCheckService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FraudCheckServiceTest {

    @InjectMocks
    private FraudCheckService fraudCheckService;

    @Mock
    private FraudCheckHistoryJpaRepository fraudCheckHistoryJpaRepository;
}
