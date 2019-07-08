package com.krloxz.training.configclientapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "some")
public class ConfigClientAppConfiguration {

  private String property;

  public String getProperty() {
    return this.property;
  }

  public void setProperty(final String property) {
    this.property = property;
  }

}
