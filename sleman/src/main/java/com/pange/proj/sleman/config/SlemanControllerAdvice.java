package com.pange.proj.sleman.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pange.proj.sleman.dto.base.BaseResponse;

@ControllerAdvice
public class SlemanControllerAdvice {

  private static final Logger LOG = LoggerFactory.getLogger(SlemanControllerAdvice.class);

  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public BaseResponse exceptionHandling(Exception e) {
    LOG.error(e.getMessage(), e);
    return new BaseResponse(null, false, e.getMessage());
  }

}
