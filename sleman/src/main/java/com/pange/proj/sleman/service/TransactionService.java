package com.pange.proj.sleman.service;

import java.util.Date;
import java.util.List;

import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.model.Transaction;

public interface TransactionService {
  
  Transaction findById(String id);
  
  Transaction create(Transaction transaction) throws ApplicationException;
  
  List<Transaction> findByDateBetween(Date dateStart, Date dateEnd);

}
