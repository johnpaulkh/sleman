package com.pange.proj.sleman.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pange.proj.sleman.exception.ExceptionType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleDto<T> extends BaseDto {

  private static final long serialVersionUID = -5122819686576390706L;
  
  private T value;

  public SingleDto(boolean success, String errorMessage, ExceptionType exceptionType, T value) {
    super(success, errorMessage, exceptionType);
    this.value = value;
  }
  
  public SingleDto(T value) {
    super(true, null, null);
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

}
