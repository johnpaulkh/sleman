package com.pange.proj.sleman.exception;

public class ApplicationRuntimeException extends RuntimeException implements BaseApplicationException {

  private static final long serialVersionUID = -2091846723468237000L;
  
  private final String errorMessage;
  private final ExceptionType type;
  private final Throwable rootCause;

  public ApplicationRuntimeException(String message, Throwable cause) {
    super(cause.getMessage(), cause);
    this.errorMessage = message;
    this.type = ExceptionType.UNSPECIFIED;
    this.rootCause = cause;
  }

  public ApplicationRuntimeException(String message) {
    super(message);
    this.errorMessage = message;
    this.type = ExceptionType.UNSPECIFIED;
    this.rootCause = null;
  }

  public ApplicationRuntimeException(String message, ExceptionType type) {
    super(message);
    this.errorMessage = message;
    this.type = type;
    this.rootCause = null;
  }

  public ApplicationRuntimeException(String message, ExceptionType type, Throwable cause) {
    super(cause.getMessage(), cause);
    this.errorMessage = message;
    this.type = type;
    this.rootCause = cause;
  }

  @Override
  public String getErrorMessage() {
    return errorMessage;
  }

  @Override
  public ExceptionType getType() {
    return type;
  }

  @Override
  public Throwable getRootCause() {
    return rootCause;
  }
  
}
