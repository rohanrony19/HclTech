package com.springboot.finclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FinclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinclientApplication.class, args);
	}

}
