package com.microservices.citizenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient					//not actually required now
public class CitizenserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitizenserviceApplication.class, args);
	}

}
