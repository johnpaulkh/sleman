package com.pange.proj.sleman.service.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pange.proj.sleman.model.Product;
import com.pange.proj.sleman.model.ProductSearch;
import com.pange.proj.sleman.repository.ProductRepository;
import com.pange.proj.sleman.service.ProductService;

@Service
public class ProductServiceBean implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product findById(String id) {
    return productRepository.findOne(id);
  }

  @Override
  public List<Product> findBySearch(ProductSearch productSearch) {
    return productRepository.findByProductNameIgnoreCaseContainingOrProductCodeIgnoreCaseContaining(
        productSearch.getProductName(), productSearch.getProductCode());
  }

}
