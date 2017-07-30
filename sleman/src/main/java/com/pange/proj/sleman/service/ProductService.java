package com.pange.proj.sleman.service;

import java.util.List;

import com.pange.proj.sleman.model.Product;
import com.pange.proj.sleman.model.ProductSearch;

public interface ProductService {

  Product create(Product product);

  Product findById(String id);

  List<Product> findBySearch(ProductSearch productSearch);

}
