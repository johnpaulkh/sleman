package com.pange.proj.sleman.model;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public class ProductSearch {

  private String productName;

  private String productCode;

  public String getProductCode() {
    return productCode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

}
