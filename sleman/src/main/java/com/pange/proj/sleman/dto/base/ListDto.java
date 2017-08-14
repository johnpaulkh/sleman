package com.pange.proj.sleman.dto.base;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pange.proj.sleman.exception.ExceptionType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListDto<T> extends BaseDto {

  private static final long serialVersionUID = -5740162547274741125L;
  
  private List<T> content;
  private long page;
  private long size;

  public ListDto(boolean success, String errorMessage, ExceptionType exceptionType,
      List<T> content, long page, long size) {
    super(success, errorMessage, exceptionType);
    this.content = content;
    this.page = page;
    this.size = size;
  }

  public ListDto(List<T> content, long page, long size) {
    super(true, null, null);
    this.content = content;
    this.page = page;
    this.size = size;
  }
  
  public ListDto(List<T> content) {
    super(true, null, null);
    this.content = content;
  }

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }

  public long getPage() {
    return page;
  }

  public void setPage(long page) {
    this.page = page;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }


}
