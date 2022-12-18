package com.example.tz.controllers;

import com.example.tz.services.LimitService;
import com.example.tz.web.LimitDto;
import com.example.tz.web.SaveLimitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limits")
@RequiredArgsConstructor
public class LimitController {
    private final LimitService limitService;

    @GetMapping("/{bankAccount}")
    public List<LimitDto> getLimits(@PathVariable Long bankAccount) {
        return limitService.getLimits(bankAccount);
    }

    @PostMapping
    public LimitDto postLimit(@RequestBody SaveLimitDto saveLimitDto) {
        return limitService.createLimitForAccount(saveLimitDto);
    }

    @PutMapping
    public void changeLimit(@RequestBody SaveLimitDto saveLimitDto) {
        limitService.changeLimit(saveLimitDto);
    }
}
