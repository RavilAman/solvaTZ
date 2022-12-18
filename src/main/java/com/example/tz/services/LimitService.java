package com.example.tz.services;

import com.example.tz.web.LimitDto;
import com.example.tz.web.SaveLimitDto;

import java.util.List;

public interface LimitService {

    List<LimitDto> getLimits();

    void changeLimit(SaveLimitDto saveLimitDto);

    LimitDto createLimitForAccount(SaveLimitDto saveLimitDto);
}
