package com.pange.proj.sleman.validator;

import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.exception.ExceptionType;

public class ArgumentChecker {
  
  public static void checkArgument(boolean argument, String errorMessage)
      throws ApplicationException {
    if (argument) {
      throw new ApplicationException(errorMessage, ExceptionType.VALIDATION);
    }
  }

}
