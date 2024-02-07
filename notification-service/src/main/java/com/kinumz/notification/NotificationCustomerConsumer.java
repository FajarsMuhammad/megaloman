package com.kinumz.notification;

import com.kinumz.domain.CustomerEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationCustomerConsumer {

    @KafkaListener(
        topics = "${spring.kafka.customer-topic}",
        groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(CustomerEvent customerEvent) {
        log.info("send notification to customer {}", customerEvent);
    }
}
