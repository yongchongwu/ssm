package com.ssm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:async.properties", ignoreResourceNotFound = true)
public class AsyncProperties {

  @Value("${async.corePoolSize}")
  private int corePoolSize = 2;
  @Value("${async.maxPoolSize}")
  private int maxPoolSize = 50;
  @Value("${async.queueCapacity}")
  private int queueCapacity = 10000;

  public int getCorePoolSize() {
    return this.corePoolSize;
  }

  public void setCorePoolSize(int corePoolSize) {
    this.corePoolSize = corePoolSize;
  }

  public int getMaxPoolSize() {
    return this.maxPoolSize;
  }

  public void setMaxPoolSize(int maxPoolSize) {
    this.maxPoolSize = maxPoolSize;
  }

  public int getQueueCapacity() {
    return this.queueCapacity;
  }

  public void setQueueCapacity(int queueCapacity) {
    this.queueCapacity = queueCapacity;
  }

}
