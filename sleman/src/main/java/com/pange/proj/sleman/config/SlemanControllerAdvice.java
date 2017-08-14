package com.pange.proj.sleman.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pange.proj.sleman.dto.base.BaseDto;
import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.exception.ExceptionType;

@ControllerAdvice
public class SlemanControllerAdvice {
  
  private static final Logger LOG = LoggerFactory.getLogger(SlemanControllerAdvice.class);
  
  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public BaseDto partnersExceptionHandler(Exception e) {
    LOG.error(e.getMessage(), e);
    return new BaseDto(false, e.getMessage(), ExceptionType.UNSPECIFIED);
  }

  @ResponseBody
  @ExceptionHandler(value = {ApplicationException.class})
  public BaseDto partnersExceptionHandler(ApplicationException e) {
    LOG.error(e.getErrorMessage(), e.getRootCause());
    return new BaseDto(false, e.getErrorMessage(), e.getType());
  }

}
