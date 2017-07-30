package com.pange.proj.sleman.dto.base;

public class SingleResponse<T> extends BaseResponse {

  private static final long serialVersionUID = 1L;

  private T content;

  public SingleResponse() {
    super();
  }

  public SingleResponse(String requestId, boolean success, String errorMessage) {
    super(requestId, success, errorMessage);
  }

  public SingleResponse(String requestId, T content) {
    super(requestId, false, null);
    this.content = content;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

}
