package com.microservices.vaccinationcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCircuitBreaker			//used for enabling hystrix
@EnableDiscoveryClient
public class VaccinationcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationcenterApplication.class, args);
	}



}
