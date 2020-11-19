package com.anisimov.denis.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderEurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderEurekaClientApplication.class, args);
	}
}

