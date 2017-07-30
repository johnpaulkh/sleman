package com.pange.proj.sleman.dto;

import java.io.Serializable;

import com.pange.proj.sleman.model.Product;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public class TransactionDetailDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private Product product;

  private TransactionDto transaction;

  private Long sellingPrice;

  private Long originalSellingPrice;

  private Long quantity;

  public String getId() {
    return id;
  }

  public Long getOriginalSellingPrice() {
    return originalSellingPrice;
  }

  public Product getProduct() {
    return product;
  }

  public Long getQuantity() {
    return quantity;
  }

  public Long getSellingPrice() {
    return sellingPrice;
  }

  public TransactionDto getTransaction() {
    return transaction;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setOriginalSellingPrice(Long originalSellingPrice) {
    this.originalSellingPrice = originalSellingPrice;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public void setSellingPrice(Long sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public void setTransaction(TransactionDto transaction) {
    this.transaction = transaction;
  }

}
