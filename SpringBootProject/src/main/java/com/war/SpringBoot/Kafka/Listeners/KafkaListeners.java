package com.war.SpringBoot.Kafka.Listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
	
	@KafkaListener(topics = "MyFirstKafkaTopic",
			groupId = "groupId")
	void listener(String data) {
		System.out.println("This is-----------> "+data);
	}

}
