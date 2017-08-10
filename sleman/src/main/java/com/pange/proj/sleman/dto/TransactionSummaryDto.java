package com.pange.proj.sleman.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionSummaryDto implements Serializable {

  private static final long serialVersionUID = 5971739137071779445L;

  private Date dateStart;
  private Date dateEnd;
  private List<TransactionDto> transactions;
  private Double totalSellingPrice;
  private Double totalBasePrice;

  public TransactionSummaryDto() {
    super();
  }

  public Date getDateStart() {
    return dateStart;
  }

  public void setDateStart(Date dateStart) {
    this.dateStart = dateStart;
  }

  public Date getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(Date dateEnd) {
    this.dateEnd = dateEnd;
  }

  public List<TransactionDto> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<TransactionDto> transactions) {
    this.transactions = transactions;
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
}
