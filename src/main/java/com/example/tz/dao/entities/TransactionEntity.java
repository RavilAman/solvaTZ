package com.example.tz.dao.entities;


import com.example.tz.web.LimitExceededTransactionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NamedNativeQuery(
        name = "get_limit_exceeded_transactions",
        query = "select " +
                "transactions.account_from as accountFrom, " +
                "transactions.account_to as accountTo, " +
                "transactions.currency_short_name as currencyShortName, " +
                "transactions.date_time as dateTime, " +
                "transactions.expense_category as expenseCategory, " +
                "transactions.sum as sum, " +
                "limits.limit_sum as limitSum, " +
                "limits.limit_datetime as limitDateTime, " +
                "limits.limit_currency_shortname as limitCurrencyShortName\n" +
                "from transactions\n" +
                "left join limits on transactions.account_from = limits.bank_account and transactions.expense_category = limits.limit_type\n" +
                "where transactions.limit_exceeded = true and transactions.account_from = :bankAccount",
        resultSetMapping = "limit_exceeded_transaction_dto"
)
@SqlResultSetMapping(
        name = "limit_exceeded_transaction_dto",
        classes = @ConstructorResult(
                targetClass = LimitExceededTransactionDto.class,
                columns = {
                        @ColumnResult(name = "accountFrom", type = String.class),
                        @ColumnResult(name = "accountTo", type = String.class),
                        @ColumnResult(name = "currencyShortName", type = String.class),
                        @ColumnResult(name = "sum", type = Double.class),
                        @ColumnResult(name = "expenseCategory", type = String.class),
                        @ColumnResult(name = "dateTime", type = String.class),
                        @ColumnResult(name = "limitSum", type = Double.class),
                        @ColumnResult(name = "limitDateTime", type = String.class),
                        @ColumnResult(name = "limitCurrencyShortName", type = String.class),
                }
        )
)
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
    private String accountFrom;

    @Column(name = "account_To")
    private String accountTo;

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
}
