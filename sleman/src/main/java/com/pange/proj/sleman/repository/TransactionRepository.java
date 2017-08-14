package com.pange.proj.sleman.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pange.proj.sleman.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

  List<Transaction> findByTransactionTimeBetween(Date dateStart, Date dateEnd);
  
}
