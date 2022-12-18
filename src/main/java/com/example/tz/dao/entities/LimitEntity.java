package com.example.tz.dao.entities;


import com.example.tz.web.LimitDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "limits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LimitEntity {

    @EmbeddedId
    private LimitEntityPk pk;

    @Column(name = "limit_sum")
    private double limitSum;

    @Column(name = "limit_datetime")
    private String limitDatetime;

    @Column(name = "limit_remains")
    private double limitRemains;

    @Column(name = "limit_currency_shortname")
    private String limitCurrencyShortname;

    public LimitDto toDto() {
        return new LimitDto(
                pk.getBankAccount(),
                pk.getLimitType(),
                limitSum,
                limitDatetime,
                limitRemains,
                limitCurrencyShortname
        );
    }
}
