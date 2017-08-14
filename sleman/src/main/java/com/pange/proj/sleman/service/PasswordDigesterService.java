package com.pange.proj.sleman.service;

public interface PasswordDigesterService {

  String getDigestedPassword(String plain);
  
  boolean comparePassword(String plain, String digested);
  
}
