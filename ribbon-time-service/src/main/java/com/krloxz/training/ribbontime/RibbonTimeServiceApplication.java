package com.krloxz.training.ribbontime;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class RibbonTimeServiceApplication {

  @Value("${server.port}")
  private String port;

  public static void main(final String[] args) {
    SpringApplication.run(RibbonTimeServiceApplication.class, args);
  }

  @GetMapping
  public String getTime() {
    return "The current time is " + new Date()
        + "(answered by service running on " + this.port + ")";
  }

}
