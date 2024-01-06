package com.kinumz.kafka.controller;

import com.kinumz.kafka.payload.Student;
import com.kinumz.kafka.producer.KafkaJsonProducer;
import com.kinumz.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

  private final KafkaProducer kafkaProducer;

  private final KafkaJsonProducer kafkaJsonProducer;

  @PostMapping
  public ResponseEntity<String> sendMessage(@RequestBody String message) {
    kafkaProducer.sendMessage(message);
    return ResponseEntity.ok("Message queue successfully");
  }

  @PostMapping("/json")
  public ResponseEntity<String> sendJsonMessage(@RequestBody Student message) {
    kafkaJsonProducer.sendMessage(message);
    return ResponseEntity.ok("Message queue successfully as JSON");
  }

}
