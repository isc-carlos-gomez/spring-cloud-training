package com.krloxz.training.datetimeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@RestController
public class DatetimeAppApplication {

  @Autowired
  private DatetimeService service;

  public static void main(final String[] args) {
    SpringApplication.run(DatetimeAppApplication.class, args);
  }

  @GetMapping("/current/datetime")
  public String getCurrentDatetime() {
    return "The current datetime is " + this.service.getDatetime();
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
