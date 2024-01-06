package com.kinumz.kafka.consumer;

import com.kinumz.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

  //@KafkaListener(topics = "fajars", groupId = "myGroup")
  public void consumeMsg(String msg) {
    log.info(String.format("Consuming the message from fajars topic:: %s", msg));
  }

  @KafkaListener(topics = "fajars", groupId = "myGroup")
  public void consumeJsonMsg(Student msg) {
    log.info(String.format("Consuming the json message from fajars topic:: %s", msg.toString()));
  }
}
