package com.util.uni.producerService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.util.uni.producerService.dao.BabyNames;
import com.util.uni.producerService.dao.DbConnect;
import com.util.uni.producerService.kafka.MyKafkaProducer;

@RestController
@EnableAutoConfiguration
public class MainRestController {
	private static final Logger logger = LoggerFactory.getLogger(MainRestController.class);
	
	@Autowired
	private MyKafkaProducer myKafkaProducer;
	@Autowired
	private DbConnect dbConnect;

	public void setDbConnect(DbConnect dbConnect) {
		this.dbConnect = dbConnect;
	}
	
	public void setMyKafkaProducer(MyKafkaProducer myKafkaProducer) {
		this.myKafkaProducer = myKafkaProducer;
	}
	
	@RequestMapping(value="/post", method= RequestMethod.POST)
	public void sendMessage(@RequestParam("msg") String msg) {
		myKafkaProducer.publishtoKafkaTopic(msg);
	}
	
	
	@RequestMapping(value="/publishBabyNames", method= RequestMethod.GET)
	public void publishBabyNames() throws Exception {
		List<BabyNames> list = dbConnect.getRecords();
		int count = 0;
		for(BabyNames name : list) {
			myKafkaProducer.publishBabyName(name);
			count++;
			if(count%50 == 0) {
				System.out.println("Published messages "+ count);
				Thread.sleep(2000);
			}
		} 
	}
}


