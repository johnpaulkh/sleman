package com.pange.proj.sleman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScans(value = {@ComponentScan(basePackages = "com.pange.proj.sleman.repository"),
    @ComponentScan(basePackages = "com.pange.proj.sleman.service")})
public class ServiceConfiguration {

  @Bean
  public static SlemanDeserializationProblemHandler getDeserializationProblemHandler() {
    return new SlemanDeserializationProblemHandler();
  }

  @Bean
  public ObjectMapper getObjectMapper() {
    ObjectMapper objMapper = new ObjectMapper();
    objMapper.setSerializationInclusion(Include.NON_NULL);
    objMapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
    objMapper.addHandler(ServiceConfiguration.getDeserializationProblemHandler());
    return objMapper;
  }

}
