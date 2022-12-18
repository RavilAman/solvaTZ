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
public class LimitDto {
    private Long bankAccount;
    private String limitType;
    private double limitSum;
    private String dateTime;
    private double limitRemains;
}
