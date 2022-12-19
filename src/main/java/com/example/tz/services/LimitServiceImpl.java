package com.example.tz.services;

import com.example.tz.dao.entities.LimitEntity;
import com.example.tz.dao.entities.LimitEntityPk;
import com.example.tz.dao.repos.LimitRepository;
import com.example.tz.web.LimitDto;
import com.example.tz.web.SaveLimitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
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
    public List<LimitDto> getLimits(String bankAccount) {
        return limitRepository.getLimitEntitiesBy(bankAccount).stream().map(LimitEntity::toDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void changeLimit(SaveLimitDto saveLimitDto) {
        limitRepository.setLimitSum(
                new LimitEntityPk(saveLimitDto.getBankAccount(), saveLimitDto.getLimitType()),
                saveLimitDto.getLimitSum(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ssXXX", Locale.getDefault()).format(new Date()));
    }

    @Override
    public LimitDto createLimitForAccount(SaveLimitDto saveLimitDto) {
        return limitRepository.save(
                new LimitEntity(
                        new LimitEntityPk(saveLimitDto.getBankAccount(), saveLimitDto.getLimitType()),
                        0,
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ssXXX", Locale.getDefault()).format(new Date()),
                        0
                )
        ).toDto();
    }

    @Scheduled(cron = "${cron.monthLimit}")
    @Transactional
    void dropLimit() {
        limitRepository.dropMonthlyLimitValue();
    }
}
