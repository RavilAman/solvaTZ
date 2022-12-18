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
public class LimitExceededTransactionDto {
    private long accountFrom;
    private long accountTo;
    private String currencyShortName;
    private double sum;
    private String expenseCategory;
    private String dateTime;
    private double limitSum;
    private String limitDateTime;
    private String limitCurrencyShortName;
}
