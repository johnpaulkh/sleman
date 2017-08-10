package com.pange.proj.sleman.service;

import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.model.Employee;

public interface EmployeeService {
  
  Employee findByUsernameAndPassword(String username, String password);
  
  Employee findByUsername(String username);
  
  boolean authenticate(String username, String password);
  
  Employee create(Employee employee);
  
  Employee update(Employee employee) throws ApplicationException;

}
