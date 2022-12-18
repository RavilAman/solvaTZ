package com.example.tz.controllers;


import com.example.tz.services.LimitService;
import com.example.tz.web.LimitDto;
import com.example.tz.web.SaveLimitDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limits")
@RequiredArgsConstructor
public class LimitController {
    private final LimitService limitService;

    @GetMapping
    public List<LimitDto> getLimits() {
        return limitService.getLimits();
    }

    @PutMapping
    public void changeLimit(@RequestBody SaveLimitDto saveLimitDto) {
        limitService.changeLimit(saveLimitDto);
    }
}
