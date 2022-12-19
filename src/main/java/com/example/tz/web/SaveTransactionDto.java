package com.example.tz.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveTransactionDto {
    private String accountFrom;
    private String accountTo;
    private String currencyShortname;
    private double sum;
    private String expenseCategory;
}
