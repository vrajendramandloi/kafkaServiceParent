package com.util.uni.producerService.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.util.uni.producerService.dao.BabyNames;

@Component
public class MyKafkaProducer {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemp;
	
	private static String topicName = "mySBServiceTopic";
	
	public void setKafkaTemp(KafkaTemplate<String, String> kafkaTemp) {
		this.kafkaTemp = kafkaTemp;
	}
	public void publishtoKafkaTopic(String message) {
		this.kafkaTemp.send(topicName, message);
	}
	
	public void publishtoKafkaPartition(String key, String message) {
		
	}
	
	public void publishBabyName(BabyNames babyName) {
		this.kafkaTemp.send(topicName, babyName.toString());
	}
}
