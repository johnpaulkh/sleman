package com.pange.proj.sleman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pange.proj.sleman.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

  List<Product> findByProductNameIgnoreCaseContainingOrProductCodeIgnoreCaseContaining(
      String productName, String productCode);
  
  Product findByProductCode(String productCode);

}
