package com.krloxz.training.cloudservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class CloudserviceApplication {

  @Value("${service.instance.name}")
  private String instance;

  public static void main(final String[] args) {
    SpringApplication.run(CloudserviceApplication.class, args);
  }

  @RequestMapping("/")
  public String message() {
    return "Hello from " + this.instance;
  }
}
