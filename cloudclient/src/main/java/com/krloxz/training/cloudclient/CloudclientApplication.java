package com.krloxz.training.cloudclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class CloudclientApplication {

  @Autowired
  private EurekaClient client;

  @Autowired
  private RestTemplateBuilder restTemplateBuilder;

  public static void main(final String[] args) {
    SpringApplication.run(CloudclientApplication.class, args);
  }

  @RequestMapping("/")
  public String callService() {
    final RestTemplate restTemplate = this.restTemplateBuilder.build();
    final InstanceInfo instanceInfo = this.client.getNextServerFromEureka("cloudservice", false);
    final String baseUrl = instanceInfo.getHomePageUrl();
    final ResponseEntity<String> response =
        restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
    return response.getBody();
  }

}
