package com.example.tz.services;

import com.example.tz.dao.entities.LimitEntity;
import com.example.tz.dao.repos.LimitRepository;
import com.example.tz.web.LimitDto;
import com.example.tz.web.SaveLimitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LimitServiceImpl implements LimitService{

    private final LimitRepository limitRepository;

    @Override
    public List<LimitDto> getLimits() {
        return limitRepository.findAll().stream().map(LimitEntity::toDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void changeLimit(SaveLimitDto saveLimitDto) {
        limitRepository.setLimitSum(
                saveLimitDto.getLimitType(),
                saveLimitDto.getLimitSum(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ssXXX", Locale.getDefault()).format(new Date()));
    }

    // добавить метод для сброса лимита каждый месяц на ноль
}
