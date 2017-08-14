package com.pange.proj.sleman.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.karneim.pojobuilder.GeneratePojoBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@GeneratePojoBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private Date transactionTime;
  private Double totalSellingPrice;
  private Double totalBasePrice;
  private EmployeeResponse employee;
  private List<TransactionDetailDto> transactionDetails;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getTransactionTime() {
    return transactionTime;
  }

  public void setTransactionTime(Date transactionTime) {
    this.transactionTime = transactionTime;
  }

  public Double getTotalSellingPrice() {
    return totalSellingPrice;
  }

  public void setTotalSellingPrice(Double totalSellingPrice) {
    this.totalSellingPrice = totalSellingPrice;
  }

  public Double getTotalBasePrice() {
    return totalBasePrice;
  }

  public void setTotalBasePrice(Double totalBasePrice) {
    this.totalBasePrice = totalBasePrice;
  }

  public EmployeeResponse getEmployee() {
    return employee;
  }

  public void setEmployee(EmployeeResponse employee) {
    this.employee = employee;
  }

  public List<TransactionDetailDto> getTransactionDetails() {
    return transactionDetails;
  }

  public void setTransactionDetails(List<TransactionDetailDto> transactionDetails) {
    this.transactionDetails = transactionDetails;
  }
}
