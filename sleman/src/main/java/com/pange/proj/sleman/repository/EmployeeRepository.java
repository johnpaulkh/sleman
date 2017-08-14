package com.pange.proj.sleman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pange.proj.sleman.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

  Employee findByUsernameAndPassword(String username, String password);
  
  Employee findByUsername(String username);
  
}
