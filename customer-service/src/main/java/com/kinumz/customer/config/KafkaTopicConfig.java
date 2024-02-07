package com.kinumz.customer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    //@Value("${spring.kafka.customer-topic}")
    //private String customerTopicName;

    @Bean
    public NewTopic customerTopic(){
        return TopicBuilder
            .name("megaloman-customer")
            .build();
    }
}
