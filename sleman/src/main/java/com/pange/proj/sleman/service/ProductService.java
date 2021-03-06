package com.pange.proj.sleman.service;

import java.util.List;

import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.model.Product;
import com.pange.proj.sleman.model.ProductSearch;

public interface ProductService {

  Product findById(String id);

  List<Product> findBySearch(ProductSearch productSearch);
  
  Product create(Product product);
  
  Product update(Product product) throws ApplicationException;

}
