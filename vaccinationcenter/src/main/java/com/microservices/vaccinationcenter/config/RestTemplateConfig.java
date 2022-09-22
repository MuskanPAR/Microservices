package com.microservices.vaccinationcenter.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced           //with this, eureka will identify service needed by it's name. We dont have to mention port name while calling citizen service
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
