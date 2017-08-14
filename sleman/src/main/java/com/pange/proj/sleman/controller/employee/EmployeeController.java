package com.pange.proj.sleman.controller.employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pange.proj.sleman.dto.EmployeeResponse;
import com.pange.proj.sleman.dto.EmployeeRequest;
import com.pange.proj.sleman.dto.base.SingleDto;
import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.model.Employee;
import com.pange.proj.sleman.service.EmployeeService;

@RestController
@RequestMapping(value = EmployeeControllerPath.BASE_PATH)
@Api(value = "Employee API")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private ModelMapper modelMapper;

  @GetMapping(value = EmployeeControllerPath.FIND_BY_USERNAME_PASS)
  @ApiOperation(value = "find by username and password")
  public SingleDto<EmployeeResponse> findByUsernameAndPassword(@RequestParam String username,
      @RequestParam String password) throws ApplicationException {
    return new SingleDto<>(getEmployeeDtoFromEntity(employeeService.findByUsernameAndPassword(
        username, password)));
  }

  @GetMapping(value = EmployeeControllerPath.FIND_BY_USERNAME)
  @ApiOperation(value = "find by username")
  public SingleDto<EmployeeResponse> findByUsername(@RequestParam String username)
      throws ApplicationException {
    return new SingleDto<>(getEmployeeDtoFromEntity(employeeService.findByUsername(username)));
  }

  @PostMapping(value = EmployeeControllerPath.CREATE)
  @ApiOperation(value = "create employee")
  public SingleDto<EmployeeResponse> create(@RequestBody EmployeeRequest employee) {
    return new SingleDto<>(getEmployeeDtoFromEntity(employeeService.create(modelMapper.map(
        employee, Employee.class))));
  }

  @PostMapping(value = EmployeeControllerPath.UPDATE)
  @ApiOperation(value = "update employee")
  public SingleDto<EmployeeResponse> update(@RequestBody EmployeeRequest employee)
      throws ApplicationException {
    return new SingleDto<>(getEmployeeDtoFromEntity(employeeService.update(modelMapper.map(
        employee, Employee.class))));
  }

  private EmployeeResponse getEmployeeDtoFromEntity(Employee employee) {
    return modelMapper.map(employee, EmployeeResponse.class);
  }
}
