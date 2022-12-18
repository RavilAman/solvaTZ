package com.example.tz.services;

import com.example.tz.web.LimitExceededTransactionDto;
import com.example.tz.web.SaveTransactionDto;

import java.util.List;

public interface TransactionService {
    void createTransaction(SaveTransactionDto saveTransactionDto);
    List<LimitExceededTransactionDto> getLimitExceededTransactions(Long bankAccount);
}
