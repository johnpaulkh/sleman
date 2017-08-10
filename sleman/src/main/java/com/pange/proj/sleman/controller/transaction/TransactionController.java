package com.pange.proj.sleman.controller.transaction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pange.proj.sleman.controller.utils.ApplicationDateConverter;
import com.pange.proj.sleman.dto.TransactionDto;
import com.pange.proj.sleman.dto.TransactionSummaryDto;
import com.pange.proj.sleman.exception.ApplicationException;
import com.pange.proj.sleman.model.Transaction;
import com.pange.proj.sleman.service.TransactionService;
import com.pange.proj.sleman.validator.TransactionValidator;

@Controller
@RequestMapping(value = TransactionControllerPath.BASE_PATH)
@Api(value = "Transaction API")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;
  @Autowired
  private ModelMapper modelMapper;

  @PostMapping(value = TransactionControllerPath.CREATE)
  @ApiOperation(value = "create transaction")
  public TransactionDto create(@RequestBody TransactionDto transaction) throws ApplicationException {
    TransactionValidator.validateForCreate(transaction);
    return modelMapper.map(
        transactionService.create(modelMapper.map(transaction, Transaction.class)),
        TransactionDto.class);
  }

  @GetMapping(value = TransactionControllerPath.FIND_BY_ID)
  @ApiOperation(value = "find by id")
  public TransactionDto findById(@RequestParam String id) {
    return modelMapper.map(transactionService.findById(id), TransactionDto.class);
  }

  @GetMapping(value = TransactionControllerPath.SUMMARY)
  @ApiOperation(value = "find summary by date")
  public TransactionSummaryDto findSummaryByDate(@RequestParam String stringDateStart,
      @RequestParam String stringDateEnd, @RequestParam boolean includeTransactions)
      throws ApplicationException {
    Date dateStart = ApplicationDateConverter.getDateFromString(stringDateStart);
    Date dateEnd = ApplicationDateConverter.getDateFromString(stringDateEnd);
    List<Transaction> transactions = transactionService.findByDateBetween(dateStart, dateEnd);
    return getTransactionSummary(dateStart, dateEnd, transactions, includeTransactions);
  }

  private TransactionSummaryDto getTransactionSummary(Date dateStart, Date dateEnd,
      List<Transaction> transactions, boolean includeTransaction) {
    TransactionSummaryDto result = new TransactionSummaryDto();
    result.setDateStart(dateStart);
    result.setDateEnd(dateEnd);
    result.setTotalBasePrice(transactions.stream().mapToDouble(Transaction::getTotalBasePrice)
        .sum());
    result.setTotalSellingPrice(transactions.stream()
        .mapToDouble(Transaction::getTotalSellingPrice).sum());
    if (includeTransaction) {
      result.setTransactions(transactions.stream()
          .map(e -> modelMapper.map(e, TransactionDto.class)).collect(Collectors.toList()));
    }
    return result;
  }

}
