package com.pange.proj.sleman.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@Entity
@Table(name = "slm_transaction_detail")
@GeneratePojoBuilder
public class TransactionDetail {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Column(name = "id")
  private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "transaction_id")
  private Transaction transaction;

  @Column(name = "selling_price")
  private Long sellingPrice;

  @Column(name = "original_selling_price")
  private Long originalSellingPrice;

  @Column(name ="quantity")
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

  public Transaction getTransaction() {
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

  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }

}
