package com.pange.proj.sleman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pange.proj.sleman.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

  Employee findByUsernameAndPassword(String username, String password);
  
  Employee findByUsername(String username);
  
}
