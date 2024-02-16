package com.kinumz.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerProducer {

    private final NewTopic customerTopic;

    private final KafkaTemplate<String, CustomerEvent> kafkaTemplate;

    public void sendMessage(CustomerEvent customerEvent) {
        log.info("Send customer event to kafka {} with topic {} ", customerEvent,
                 customerTopic.name());

        Message<CustomerEvent> message = MessageBuilder
            .withPayload(customerEvent)
            .setHeader(KafkaHeaders.TOPIC, customerTopic.name())
            .build();

        kafkaTemplate.send(message);
    }

}
