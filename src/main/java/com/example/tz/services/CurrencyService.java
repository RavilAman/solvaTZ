package com.example.tz.services;


import com.example.tz.dao.repos.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    private void setCurrency() {

    }
}
