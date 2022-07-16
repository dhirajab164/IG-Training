package com.dhiraj.app.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.app.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {

	@Autowired
	KafkaProducer kafkaProducer;

	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@PathParam("message") String message) {
		kafkaProducer.sendMessage(message);
		return new ResponseEntity<String>("Message Sent.", HttpStatus.OK);
	}
}
