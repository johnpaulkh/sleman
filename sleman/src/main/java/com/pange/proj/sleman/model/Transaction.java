package com.pange.proj.sleman.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@Entity
@Table(name = "slm_transaction")
@GeneratePojoBuilder
public class Transaction {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Column(name = "id")
  private String id;

  @Column(name = "transaction_time")
  private Date transactionTime;

  @Column(name = "total_price")
  private Long totalPrice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "transaction")
  private List<TransactionDetail> transactionDetails;

  public Employee getEmployee() {
    return employee;
  }

  public String getId() {
    return id;
  }

  public Long getTotalPrice() {
    return totalPrice;
  }

  public List<TransactionDetail> getTransactionDetails() {
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

  public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
    this.transactionDetails = transactionDetails;
  }

  public void setTransactionTime(Date transactionTime) {
    this.transactionTime = transactionTime;
  }

}
