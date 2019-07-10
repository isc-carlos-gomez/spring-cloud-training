package com.krloxz.training.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class TurbineApplication {

  public static void main(final String[] args) {
    SpringApplication.run(TurbineApplication.class, args);
  }

}
