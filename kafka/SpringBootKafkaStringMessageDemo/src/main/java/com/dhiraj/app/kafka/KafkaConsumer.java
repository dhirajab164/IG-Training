package com.dhiraj.app.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics = "topic1", groupId = "consumerGroup")
	public void consume(String message) {
		log.info("Message Received: {}", message);
	}

}
