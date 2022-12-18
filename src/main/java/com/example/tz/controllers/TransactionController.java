package com.example.tz.controllers;

import com.example.tz.services.TransactionService;
import com.example.tz.web.LimitExceededTransactionDto;
import com.example.tz.web.SaveTransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/{bankAccount}")
    public List<LimitExceededTransactionDto> getLimitExceededTransactions(@PathVariable Long bankAccount) {
        return transactionService.getLimitExceededTransactions(bankAccount);
    }

    @PostMapping
    public void postTransaction(@RequestBody SaveTransactionDto saveTransactionDto) {
        transactionService.createTransaction(saveTransactionDto);
    }
}
