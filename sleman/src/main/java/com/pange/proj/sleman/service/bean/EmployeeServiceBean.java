package com.pange.proj.sleman.service.bean;

import org.springframework.stereotype.Service;

import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.model.Employee;
import com.pange.proj.sleman.repository.EmployeeRepository;
import com.pange.proj.sleman.service.EmployeeService;
import com.pange.proj.sleman.validator.ArgumentChecker;

@Service
public class EmployeeServiceBean implements EmployeeService {

  private EmployeeRepository repository;
  
  @Override
  public Employee findByUsernameAndPassword(String username, String password) {
    return repository.findByUsernameAndPassword(username, password);
  }

  @Override
  public Employee findByUsername(String username) {
    return repository.findByUsername(username);
  }

  @Override
  public boolean authenticate(String username, String password) {
    return this.findByUsernameAndPassword(username, password) != null;
  }

  @Override
  public Employee create(Employee employee) {
    employee.setId(null);
    return repository.saveAndFlush(employee);
  }

  @Override
  public Employee update(Employee employee) throws ApplicationException {
    ArgumentChecker.checkArgument(findByUsername(employee.getUsername()) == null, "user tidak ditemukan");
    return repository.saveAndFlush(employee);
  }

}
