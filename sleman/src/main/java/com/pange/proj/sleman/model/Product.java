package com.pange.proj.sleman.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@Entity
@Table(name = "slm_product")
@GeneratePojoBuilder
public class Product {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Column(name = "id")
  private String id;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "selling_price")
  private Double sellingPrice;

  @Column(name = "base_price")
  private Double basePrice;

  @Column(name = "product_code")
  private String productCode;

  @Column(name = "unit")
  @Enumerated(EnumType.STRING)
  private ProductUnit unit;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
  private List<TransactionDetail> transactionDetails;

  public Double getBasePrice() {
    return basePrice;
  }

  public List<TransactionDetail> getDetilTransaksis() {
    return transactionDetails;
  }

  public String getId() {
    return id;
  }

  public String getProductCode() {
    return productCode;
  }

  public String getProductName() {
    return productName;
  }

  public Double getSellingPrice() {
    return sellingPrice;
  }

  public List<TransactionDetail> getTransactionDetails() {
    return transactionDetails;
  }

  public ProductUnit getUnit() {
    return unit;
  }

  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setSellingPrice(Double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
    this.transactionDetails = transactionDetails;
  }

  public void setUnit(ProductUnit unit) {
    this.unit = unit;
  }

}
