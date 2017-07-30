package com.pange.proj.sleman.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pange.proj.sleman.model.Employee;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public class TransactionDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private Date transactionTime;

  private Long totalPrice;

  private Employee employee;

  private List<TransactionDetailDto> transactionDetails;

  public Employee getEmployee() {
    return employee;
  }

  public String getId() {
    return id;
  }

  public Long getTotalPrice() {
    return totalPrice;
  }

  public List<TransactionDetailDto> getTransactionDetails() {
    return transactionDetails;
  }

  public Date getTransactionTime() {
    return transactionTime;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setTotalPrice(Long totalPrice) {
    this.totalPrice = totalPrice;
  }

  public void setTransactionDetails(List<TransactionDetailDto> transactionDetails) {
    this.transactionDetails = transactionDetails;
  }

  public void setTransactionTime(Date transactionTime) {
    this.transactionTime = transactionTime;
  }

}
