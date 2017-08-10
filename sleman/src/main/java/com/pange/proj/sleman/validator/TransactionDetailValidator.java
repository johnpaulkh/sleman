package com.pange.proj.sleman.validator;

import static com.pange.proj.sleman.validator.ArgumentChecker.checkArgument;

import java.util.List;

import com.pange.proj.sleman.dto.TransactionDetailDto;
import com.pange.proj.sleman.exception.ApplicationException;

public class TransactionDetailValidator {

  public static void validateForCreate(TransactionDetailDto transactionDetail)
      throws ApplicationException {
    checkArgument(transactionDetail == null, "detil transaksi harus diisi");
    checkArgument(transactionDetail.getSellingPrice() == null, "harga jual harus diisi");
    checkArgument(transactionDetail.getQuantity() == null || transactionDetail.getQuantity() <= 0,
        "kuantitas harus diisi");
    checkArgument(transactionDetail.getProduct() == null, "produk harus diisi");
    checkArgument(transactionDetail.getProduct().getId() == null
        && transactionDetail.getProduct().getProductCode() == null,
        "id atau kode produk harus diisi");
  }

  public static void validateForCreate(List<TransactionDetailDto> transactionDetails)
      throws ApplicationException {
    for (TransactionDetailDto detail : transactionDetails) {
      validateForCreate(detail);
    }
  }

}
