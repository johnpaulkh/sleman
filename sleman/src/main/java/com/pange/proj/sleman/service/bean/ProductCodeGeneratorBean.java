package com.pange.proj.sleman.service.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pange.proj.sleman.repository.ProductRepository;
import com.pange.proj.sleman.service.ProductCodeGenerator;

@Service
public class ProductCodeGeneratorBean implements ProductCodeGenerator {
  
  @Autowired
  private ProductRepository productRepository;

  @Override
  public String generateProductCode(String productName) {
    String destination = null;
    if (!StringUtils.isEmpty(String.valueOf(productName))) {
      String businessPartnerName = String.valueOf(productName).replaceAll("[^A-Za-z0-9 ]", "");
      String[] names = businessPartnerName.split(" ");
      String prefix;
      if (names.length > 1) {
        if (names[0].length() > 1) {
          prefix = names[0].substring(0, 2) + names[1].substring(0, 1);
        } else {
          prefix = names[0].substring(0, 1) + names[0].substring(0, 1) + names[1].substring(0, 1);
        }
      } else {
        if (names[0].length() > 1) {
          prefix = names[0].substring(0, 2);
        } else {
          prefix = names[0].substring(0, 1) + names[0].substring(0, 1);
        }
        prefix += names[0].substring(names[0].length() - 1);
      }
      destination = prefix.toUpperCase() + "-" + String.format("%06d", getCountProduct());
    }
    return destination;
  }

  private Long getCountProduct() {
    return productRepository.count();
  }

}
