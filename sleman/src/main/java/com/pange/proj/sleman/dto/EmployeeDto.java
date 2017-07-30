package com.pange.proj.sleman.dto;

import java.io.Serializable;
import java.util.List;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public class EmployeeDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String name;

  private String username;

  private String password;

  private List<TransactionDto> transactions;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public List<TransactionDto> getTransactions() {
    return transactions;
  }

  public String getUsername() {
    return username;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setTransactions(List<TransactionDto> transactions) {
    this.transactions = transactions;
  }

  public void setUsername(String username) {
    this.username = username;
  }



}
