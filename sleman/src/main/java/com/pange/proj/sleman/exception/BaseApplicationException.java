package com.pange.proj.sleman.exception;

/**
 * Base exception for Sleman Application
 * 
 * @author yohanes.p.k.hadinata
 *
 */
public interface BaseApplicationException {
  
  public String getErrorMessage();

  public ExceptionType getType();

  public Throwable getRootCause();

}
