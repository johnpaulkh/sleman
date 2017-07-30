package com.pange.proj.sleman.dto.base;

import java.util.List;

public class ListResponse<T> extends BaseResponse {

  private static final long serialVersionUID = 1L;

  private List<T> content;

  public ListResponse() {
    super();
  }

  public ListResponse(String requestId, boolean success, String errorMessage) {
    super(requestId, success, errorMessage);
  }

  public ListResponse(String requestId, List<T> content) {
    super(requestId, false, null);
    this.content = content;
  }

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }
}
