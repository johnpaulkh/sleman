package com.pange.proj.sleman.exception;

public class ApplicationException extends Exception {

  private static final long serialVersionUID = 6966467065061141116L;

  private final String errorMessage;
  private final ExceptionType type;

  public ApplicationException(String message, Throwable cause) {
    super(cause.getMessage(), cause);
    this.errorMessage = message;
    this.type = ExceptionType.UNSPECIFIED;
  }

  public ApplicationException(String message) {
    super(message);
    this.errorMessage = message;
    this.type = ExceptionType.UNSPECIFIED;
  }
  
  public ApplicationException(String message, ExceptionType type) {
    super(message);
    this.errorMessage = message;
    this.type = type;
  }

  public ApplicationException(String message, ExceptionType type, Throwable cause) {
    super(cause.getMessage(), cause);
    this.errorMessage = message;
    this.type = type;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public ExceptionType getType() {
    return type;
  }
}
