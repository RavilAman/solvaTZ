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
    private long accountFrom;
    private long accountTo;
    private String currencyShortname;
    private double sum;
    private String expenseCategory;
}
