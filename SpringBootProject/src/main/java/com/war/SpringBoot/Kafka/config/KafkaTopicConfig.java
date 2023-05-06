package com.war.SpringBoot.Kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    @Bean
    NewTopic FistKafkaTopic() {
		return TopicBuilder.name("MyFirstKafkaTopic")
				.build();
	}

}
