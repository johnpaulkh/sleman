package com.pange.proj.sleman.controller.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.exception.ExceptionType;

public class ApplicationDateConverter {

  public static final String DATE_FORMAT = "YYYY-MM-dd HH:mm:ss";

  public static String getStringFromDate(Date date) {
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    return dateFormat.format(date);
  }

  public static Date getDateFromString(String dateString) throws ApplicationException {
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    try {
      return dateFormat.parse(dateString);
    } catch (ParseException e) {
      throw new ApplicationException(e.getMessage(), ExceptionType.VALIDATION, e);
    }
  }

}
