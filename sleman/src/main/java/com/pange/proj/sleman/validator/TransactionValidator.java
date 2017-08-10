package com.pange.proj.sleman.validator;

import static com.pange.proj.sleman.validator.ArgumentChecker.checkArgument;

import com.pange.proj.sleman.dto.TransactionDto;
import com.pange.proj.sleman.exception.ApplicationException;

public class TransactionValidator {

  public static void validateForCreate(TransactionDto transaction) throws ApplicationException {
    checkArgument(transaction == null, "transaksi tidak boleh kosong");
    checkArgument(transaction.getEmployee() == null || transaction.getEmployee().getId() == null,
        "karyawan harus diisi");
    checkArgument(transaction.getTransactionDetails() == null
        || transaction.getTransactionDetails().size() <= 0, "detil transaksi harus diisi");
    TransactionDetailValidator.validateForCreate(transaction.getTransactionDetails());
  }

}
