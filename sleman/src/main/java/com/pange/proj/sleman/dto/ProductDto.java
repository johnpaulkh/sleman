package com.pange.proj.sleman.dto;

import net.karneim.pojobuilder.GeneratePojoBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pange.proj.sleman.model.ProductUnit;

@GeneratePojoBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto extends ProductBaseDto {

  private static final long serialVersionUID = 1L;

  private Double sellingPrice;
  private Double basePrice;
  private ProductUnit unit;

  public Double getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  public ProductUnit getUnit() {
    return unit;
  }

  public void setUnit(ProductUnit unit) {
    this.unit = unit;
  }

}
