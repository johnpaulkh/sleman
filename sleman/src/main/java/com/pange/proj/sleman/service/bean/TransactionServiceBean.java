package com.pange.proj.sleman.service.bean;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pange.proj.sleman.model.Product;
import com.pange.proj.sleman.model.Transaction;
import com.pange.proj.sleman.model.TransactionDetail;
import com.pange.proj.sleman.repository.EmployeeRepository;
import com.pange.proj.sleman.repository.ProductRepository;
import com.pange.proj.sleman.repository.TransactionRepository;
import com.pange.proj.sleman.service.TransactionService;

@Service
public class TransactionServiceBean implements TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;
  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private ProductRepository productRepository;

  @Override
  public Transaction findById(String id) {
    return transactionRepository.findOne(id);
  }

  @Override
  @Transactional
  public Transaction create(Transaction transaction) {
    setTransactionEmployee(transaction);
    setTransactionProducts(transaction);
    setTransactionTotalPrice(transaction);
    setTransactionTime(transaction);
    return transactionRepository.save(transaction);
  }

  @Override
  public List<Transaction> findByDateBetween(Date dateStart, Date dateEnd) {
    return transactionRepository
        .findByTransactionTimeGreaterThanEqualsAndTransactionTimeLessThanEquals(dateStart, dateEnd);
  }

  private void setTransactionTotalPrice(Transaction transaction) {
    if (transaction.getTotalSellingPrice() == null) {
      transaction.setTotalSellingPrice(transaction.getTransactionDetails().stream()
          .mapToDouble(TransactionDetail::getSellingPrice).sum());
    }
    if (transaction.getTotalBasePrice() == null) {
      transaction.setTotalBasePrice(transaction.getTransactionDetails().stream()
          .mapToDouble(TransactionDetail::getBasePrice).sum());
    }
  }

  private void setTransactionEmployee(Transaction transaction) {
    if (StringUtils.isEmpty(transaction.getEmployee().getName())) {
      transaction.setEmployee(employeeRepository.findOne(transaction.getEmployee().getId()));
    }
  }

  private void setTransactionDetailProductAndPrice(TransactionDetail transactionDetail) {
    Product product = transactionDetail.getProduct();
    if (StringUtils.isEmpty(product.getProductName()) || product.getSellingPrice() == null
        || product.getBasePrice() == null) {
      if (!StringUtils.isEmpty(product.getId())) {
        product = productRepository.findOne(product.getId());
      } else if (!StringUtils.isEmpty(product.getProductCode())) {
        product = productRepository.findByProductCode(product.getProductCode());
      }
      transactionDetail.setProduct(product);
    }
    if (transactionDetail.getOriginalSellingPrice() == null) {
      transactionDetail.setOriginalSellingPrice(product.getSellingPrice());
    }
    if (transactionDetail.getBasePrice() == null) {
      transactionDetail.setBasePrice(product.getBasePrice());
    }
  }

  private void setTransactionTime(Transaction transaction) {
    if (transaction.getTransactionTime() == null) {
      transaction.setTransactionTime(new Date());
    }
  }

  private void setTransactionProducts(Transaction transaction) {
    transaction.getTransactionDetails().forEach(this::setTransactionDetailProductAndPrice);
  }
}
