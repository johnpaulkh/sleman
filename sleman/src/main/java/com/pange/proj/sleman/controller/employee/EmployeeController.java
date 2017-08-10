package com.pange.proj.sleman.controller.employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pange.proj.sleman.dto.EmployeeDto;
import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.model.Employee;
import com.pange.proj.sleman.service.EmployeeService;

@Controller
@RequestMapping(value = EmployeeControllerPath.BASE_PATH)
@Api(value = "Employee API")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private ModelMapper modelMapper;

  @GetMapping(value = EmployeeControllerPath.FIND_BY_USERNAME_PASS)
  @ApiOperation(value = "find by username and password")
  public EmployeeDto findByUsernameAndPassword(@RequestParam String username,
      @RequestParam String password) {
    return modelMapper.map(employeeService.findByUsernameAndPassword(username, password),
        EmployeeDto.class);
  }

  @GetMapping(value = EmployeeControllerPath.FIND_BY_USERNAME)
  @ApiOperation(value = "find by username")
  public EmployeeDto findByUsername(@RequestParam String username) {
    return modelMapper.map(employeeService.findByUsername(username), EmployeeDto.class);
  }

  @PostMapping(value = EmployeeControllerPath.CREATE)
  @ApiOperation(value = "create employee")
  public EmployeeDto create(@RequestBody EmployeeDto employee) {
    return modelMapper.map(employeeService.create(modelMapper.map(employee, Employee.class)),
        EmployeeDto.class);
  }

  @PostMapping(value = EmployeeControllerPath.UPDATE)
  @ApiOperation(value = "update employee")
  public EmployeeDto update(@RequestBody EmployeeDto employee) throws ApplicationException {
    return modelMapper.map(employeeService.update(modelMapper.map(employee, Employee.class)),
        EmployeeDto.class);
  }
}
