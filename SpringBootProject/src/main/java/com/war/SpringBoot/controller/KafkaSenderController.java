package com.war.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.war.SpringBoot.records.MessageRequest;

@RestController
@RequestMapping("api/v1/messages")
public class KafkaSenderController {
	
	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;
	
	
	@PostMapping("/send")
	public void sendMessage(@RequestBody MessageRequest request ) {
		
		kafkaTemplate.send("MyFirstKafkaTopic", request.message());
		
	}

}
