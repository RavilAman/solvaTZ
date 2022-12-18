package com.example.tz.dao.entities;


import com.example.tz.web.LimitDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "limits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LimitEntity {

    @Id
    private String limitType;

    @Column(name = "limit_sum")
    private double limitSum;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "limit_remains")
    private double limitRemains;

    public LimitDto toDto() {
        return new LimitDto(
                limitType,
                limitSum,
                dateTime,
                limitRemains
        );
    }
}
