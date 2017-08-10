package com.pange.proj.sleman.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDetailDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private ProductDto product;
  private Double sellingPrice;
  private Double originalSellingPrice;
  private Double basePrice;
  private Double quantity;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductDto getProduct() {
    return product;
  }

  public void setProduct(ProductDto product) {
    this.product = product;
  }

  public Double getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Double getOriginalSellingPrice() {
    return originalSellingPrice;
  }

  public void setOriginalSellingPrice(Double originalSellingPrice) {
    this.originalSellingPrice = originalSellingPrice;
  }

  public Double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }
}
