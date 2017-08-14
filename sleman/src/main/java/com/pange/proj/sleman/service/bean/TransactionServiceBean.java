package com.pange.proj.sleman.service.bean;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.exception.ApplicationRuntimeException;
import com.pange.proj.sleman.exception.ExceptionType;
import com.pange.proj.sleman.model.Employee;
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
  @Transactional
  public Transaction create(Transaction transaction) throws ApplicationException {
    setTransactionEmployee(transaction);
    setTransactionProducts(transaction);
    setTransactionTotalPrice(transaction);
    setTransactionTime(transaction);
    return transactionRepository.save(transaction);
  }

  @Override
  public List<Transaction> findByDateBetween(Date dateStart, Date dateEnd) {
    return transactionRepository.findByTransactionTimeBetween(dateStart, dateEnd);
  }

  @Override
  public Transaction findById(String id) {
    return transactionRepository.findOne(id);
  }

  private Product getProduct(Product incompleteProduct) {
    Product product = null;
    if (!StringUtils.isEmpty(incompleteProduct.getId())) {
      product = productRepository.findOne(incompleteProduct.getId());
    } else if (!StringUtils.isEmpty(incompleteProduct.getProductCode())) {
      product = productRepository.findByProductCode(incompleteProduct.getProductCode());
    }
    if (product == null) {
      throw new ApplicationRuntimeException("Produk tidak ditemukan", ExceptionType.DATA_NOT_FOUND);
    }
    return product;
  }

  private void setTransactionDetailProductAndPrice(TransactionDetail transactionDetail) {
    Product product = transactionDetail.getProduct();
    if (StringUtils.isEmpty(product.getProductName()) || product.getSellingPrice() == null
        || product.getBasePrice() == null) {
      transactionDetail.setProduct(getProduct(product));
    }
    if (transactionDetail.getOriginalSellingPrice() == null) {
      transactionDetail.setOriginalSellingPrice(product.getSellingPrice());
    }
    if (transactionDetail.getBasePrice() == null) {
      transactionDetail.setBasePrice(product.getBasePrice());
    }
  }

  private void setTransactionEmployee(Transaction transaction) throws ApplicationException {
    if (StringUtils.isEmpty(transaction.getEmployee().getName())) {
      Employee employee = employeeRepository.findOne(transaction.getEmployee().getId());
      if (employee == null) {
        throw new ApplicationException("Pegawai tidak ditemukan", ExceptionType.DATA_NOT_FOUND);
      }
      transaction.setEmployee(employee);
    }
  }

  private void setTransactionProducts(Transaction transaction) {
    transaction.getTransactionDetails().stream().forEach(this::setTransactionDetailProductAndPrice);
  }

  private void setTransactionTime(Transaction transaction) {
    if (transaction.getTransactionTime() == null) {
      transaction.setTransactionTime(new Date());
    }
  }

  private void setTransactionTotalPrice(Transaction transaction) {
    if (transaction.getTotalSellingPrice() == null) {
      transaction.setTotalSellingPrice(transaction.getTransactionDetails().stream()
          .mapToDouble(e -> e.getSellingPrice() * e.getQuantity()).sum());
    }
    if (transaction.getTotalBasePrice() == null) {
      transaction.setTotalBasePrice(transaction.getTransactionDetails().stream()
          .mapToDouble(e -> e.getBasePrice() * e.getQuantity()).sum());
    }
  }
}
