package com.pange.proj.sleman.service.bean;

import org.jasypt.digest.StringDigester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pange.proj.sleman.service.PasswordDigesterService;

@Service
public class PasswordDigesterServiceBean implements PasswordDigesterService {

  @Autowired
  private StringDigester stringDigester;

  @Override
  public String getDigestedPassword(String plain) {
    return plain == null ? null : stringDigester.digest(plain);
  }

  @Override
  public boolean comparePassword(String plain, String digested) {
    return getDigestedPassword(plain) == digested;
  }

}
