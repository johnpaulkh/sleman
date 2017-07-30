package com.pange.proj.sleman.dto;

import java.io.Serializable;

import com.pange.proj.sleman.model.ProductUnit;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public class ProductDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String productName;

  private Long sellingPrice;

  private Long basePrice;

  private String productCode;

  private ProductUnit unit;

  public Long getBasePrice() {
    return basePrice;
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

  public Long getSellingPrice() {
    return sellingPrice;
  }

  public ProductUnit getUnit() {
    return unit;
  }

  public void setBasePrice(Long basePrice) {
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

  public void setSellingPrice(Long sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public void setUnit(ProductUnit unit) {
    this.unit = unit;
  }

}
