package com.pange.proj.sleman.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;

public class SlemanDeserializationProblemHandler extends DeserializationProblemHandler {

  private static final Logger LOG =
      LoggerFactory.getLogger(SlemanDeserializationProblemHandler.class);

  @Override
  public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser p,
      JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName)
      throws IOException {
    LOG.warn("unknown field : {}", propertyName);
    return true;
  }

}
