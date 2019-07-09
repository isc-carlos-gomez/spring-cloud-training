package com.krloxz.training.ribbontime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.krloxz.training.config.ribbontime.RibbonTimeConfig;

@SpringBootApplication
@RibbonClient(name = "time-service", configuration = RibbonTimeConfig.class)
@RestController
@Configuration
public class RibbonTimeAppApplication {

  @Autowired
  private RestTemplate restTemplate;

  public static void main(final String[] args) {
    SpringApplication.run(RibbonTimeAppApplication.class, args);
  }

  @GetMapping
  public String getTime() {
    return this.restTemplate.getForEntity("http://time-service", String.class).getBody();
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
