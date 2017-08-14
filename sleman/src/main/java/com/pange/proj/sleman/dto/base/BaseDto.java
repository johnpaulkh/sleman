package com.pange.proj.sleman.dto.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pange.proj.sleman.exception.ExceptionType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDto implements Serializable {

  private static final long serialVersionUID = 3556790575686998431L;

  private boolean success;
  private String errorMessage;
  private ExceptionType exceptionType;

  public BaseDto(boolean success, String errorMessage, ExceptionType exceptionType) {
    super();
    this.success = success;
    this.errorMessage = errorMessage;
    this.exceptionType = exceptionType;
  }

  public BaseDto() {
    super();
    this.success = true;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ExceptionType getExceptionType() {
    return exceptionType;
  }

  public void setExceptionType(ExceptionType exceptionType) {
    this.exceptionType = exceptionType;
  }

}
