package com.pange.proj.sleman.dto.base;

import java.io.Serializable;

public class BaseResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String requestId;

  private boolean success;

  private String errorMessage;

  public BaseResponse() {
    super();
  }

  public BaseResponse(String requestId, boolean success, String errorMessage) {
    super();
    this.requestId = requestId;
    this.success = success;
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public String getRequestId() {
    return requestId;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }



}
