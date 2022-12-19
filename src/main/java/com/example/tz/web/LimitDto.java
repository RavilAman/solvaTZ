package com.example.tz.web;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LimitDto {
    private String bankAccount;
    private String limitType;
    private double limitSum;
    private String limitDateTime;
    private double limitRemains;
}
