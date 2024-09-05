package com.tapiwanashe.pet.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties
public class PetConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetConsumerApplication.class, args);
	}

}
