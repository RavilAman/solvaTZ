package com.example.tz.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "limit_exceed_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LimitExceedHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long limit_exceed_history_id;

    @Column(name = "transaction_initiator_bank_account")
    private String transactionInitiatorBankAccount;

    @Column(name = "limit_type")
    private String limitType;

    @Column(name = "limit_sum")
    private double limitSum;

    @Column(name = "limit_datetime")
    private String limitDatetime;

    @Column(name = "limit_currency_shortname")
    private String limitCurrencyShortname;
}
