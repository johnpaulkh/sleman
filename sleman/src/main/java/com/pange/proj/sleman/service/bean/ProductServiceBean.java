package com.pange.proj.sleman.service.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.exception.ExceptionType;
import com.pange.proj.sleman.model.Product;
import com.pange.proj.sleman.model.ProductSearch;
import com.pange.proj.sleman.repository.ProductRepository;
import com.pange.proj.sleman.service.ProductCodeGenerator;
import com.pange.proj.sleman.service.ProductService;

@Service
public class ProductServiceBean implements ProductService {

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private ProductCodeGenerator productCodeGenerator;

  @Override
  public Product findById(String id) {
    return productRepository.findOne(id);
  }

  @Override
  public List<Product> findBySearch(ProductSearch productSearch) {
    return productRepository
        .findByProductNameIgnoreCaseContainingOrProductCodeIgnoreCaseContaining(
            productSearch.getProductName(), productSearch.getProductCode());
  }

  @Override
  public Product create(Product product) {
    product.setId(null);
    if (product.getProductCode() == null) {
      product.setProductCode(productCodeGenerator.generateProductCode(product.getProductName()));
    }
    return productRepository.saveAndFlush(product);
  }

  @Override
  public Product update(Product product) throws ApplicationException {
    if (findById(product.getId()) == null) {
      throw new ApplicationException("produk tidak ditemukan", ExceptionType.DATA_NOT_FOUND);
    }
    return productRepository.saveAndFlush(product);
  }

}
