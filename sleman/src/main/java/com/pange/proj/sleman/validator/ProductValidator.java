package com.pange.proj.sleman.validator;

import static com.pange.proj.sleman.validator.ArgumentChecker.checkArgument;

import org.springframework.util.StringUtils;

import com.pange.proj.sleman.dto.ProductDto;
import com.pange.proj.sleman.exception.ApplicationException;

public class ProductValidator {

  public static void validateForCreate(ProductDto product) throws ApplicationException {
    checkArgument(product == null, "produk tidak boleh kosong");
    checkArgument(StringUtils.isEmpty(product.getProductName()), "nama produk harus diisi");
    checkArgument(product.getSellingPrice() == null || product.getSellingPrice() <= 0,
        "harga jual produk harus diisi");
    checkArgument(product.getBasePrice() == null || product.getBasePrice() <= 0,
        "harga modal produk harus diisi");
    checkArgument(product.getUnit() == null, "unit produk harus diisi");
  }

  public static void validateForUpdate(ProductDto product) throws ApplicationException {
    validateForCreate(product);
    checkArgument(StringUtils.isEmpty(product.getId()), "id produk harus diisi");
    checkArgument(StringUtils.isEmpty(product.getProductCode()), "kode produk harus diisi");
  }

}
