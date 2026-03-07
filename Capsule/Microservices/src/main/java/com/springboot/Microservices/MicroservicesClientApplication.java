package com.springboot.Microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesClientApplication.class, args);
	}

}
