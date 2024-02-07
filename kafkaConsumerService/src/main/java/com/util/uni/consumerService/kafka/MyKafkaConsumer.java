package com.util.uni.consumerService.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {
	
	@KafkaListener(topics="mySBServiceTopic", groupId="mySBServiceTopic")
	public void consumerFromTopic(String message) {
		System.out.println("Consumed Message :"+message);
	}
}
