package com.pange.proj.sleman.service.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.model.Employee;
import com.pange.proj.sleman.repository.EmployeeRepository;
import com.pange.proj.sleman.service.EmployeeService;
import com.pange.proj.sleman.service.PasswordDigesterService;
import com.pange.proj.sleman.validator.ArgumentChecker;

@Service
public class EmployeeServiceBean implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private PasswordDigesterService passwordDigesterService;

  @Override
  public Employee findByUsernameAndPassword(String username, String password) throws ApplicationException {
    Employee result = employeeRepository.findByUsernameAndPassword(username,
        passwordDigesterService.getDigestedPassword(password));
    ArgumentChecker.checkArgument(result == null, "Data karyawan tidak ditemukan");
    return result;
  }

  @Override
  public Employee findByUsername(String username) throws ApplicationException {
    Employee result = employeeRepository.findByUsername(username);
    ArgumentChecker.checkArgument(result == null, "Data karyawan tidak ditemukan");
    return result;
  }

  @Override
  public boolean authenticate(String username, String password) {
    return employeeRepository.findByUsernameAndPassword(username,
        passwordDigesterService.getDigestedPassword(password)) != null;
  }

  @Override
  public Employee create(Employee employee) {
    employee.setId(null);
    employee.setPassword(passwordDigesterService.getDigestedPassword(employee.getPassword()));
    return employeeRepository.saveAndFlush(employee);
  }

  @Override
  public Employee update(Employee employee) throws ApplicationException {
    Employee existingEmployee = findByUsername(employee.getUsername());
    ArgumentChecker.checkArgument(existingEmployee == null, "user tidak ditemukan");
    employee.setPassword(employee.getPassword() != null ? passwordDigesterService
        .getDigestedPassword(employee.getPassword()) : existingEmployee.getPassword());
    return employeeRepository.saveAndFlush(employee);
  }

}
