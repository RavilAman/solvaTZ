package com.example.tz.dao.entities;


import com.example.tz.web.LimitExceededTransactionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "account_from")
    private long accountFrom;

    @Column(name = "account_To")
    private long accountTo;

    @Column(name = "currency_short_name")
    private String currencyShortName;

    @Column
    private double sum;

    @Column(name = "expense_category")
    private String expenseCategory;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "limit_exceeded")
    private boolean limitExceeded;

    public LimitExceededTransactionDto toLimitExceededTransactionDto(double limitSum, String limitDateTime, String limitCurrencyShortName) {
        return new LimitExceededTransactionDto(
                accountFrom,
                accountTo,
                currencyShortName,
                sum,
                expenseCategory,
                dateTime,
                limitSum,
                limitDateTime,
                limitCurrencyShortName
        );
    }
}
