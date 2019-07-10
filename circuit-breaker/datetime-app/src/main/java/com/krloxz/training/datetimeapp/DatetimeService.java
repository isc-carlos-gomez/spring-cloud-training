package com.krloxz.training.datetimeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DatetimeService {

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(defaultFallback = "unknown")
  public String getDatetime() {
    return this.restTemplate.getForEntity("http://datetime-service/datetime", String.class)
        .getBody();
  }

  @SuppressWarnings("unused")
  private String unknown() {
    return "unknown";
  }

}
