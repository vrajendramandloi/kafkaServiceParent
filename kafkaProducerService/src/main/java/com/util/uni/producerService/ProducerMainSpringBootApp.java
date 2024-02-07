package com.util.uni.producerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootConfiguration
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ProducerMainSpringBootApp {
	private static final Logger logger = LoggerFactory.getLogger(ProducerMainSpringBootApp.class);
	public static void main(String[] args) {
		SpringApplication.run(ProducerMainSpringBootApp.class, args);
	}

}
