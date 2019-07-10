package com.krloxz.training.weatherservice;

import java.util.concurrent.ThreadLocalRandom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class WeatherServiceApplication {

  private static final String[] WEATHER = new String[] {"sunny", "cloudy", "rainy", "windy"};

  public static void main(final String[] args) {
    SpringApplication.run(WeatherServiceApplication.class, args);
  }

  @GetMapping("/weather")
  public String getWeather() {
    final int random = ThreadLocalRandom.current().nextInt(0, 4);
    return WEATHER[random];
  }

}
