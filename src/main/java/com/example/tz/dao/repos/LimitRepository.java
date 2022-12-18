package com.example.tz.dao.repos;

import com.example.tz.dao.entities.LimitEntity;
import com.example.tz.dao.entities.LimitEntityPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LimitRepository extends JpaRepository<LimitEntity, String> {

    @Modifying
    @Query("update LimitEntity l set l.limitRemains = l.limitRemains + ?2 - l.limitSum, l.limitSum = ?2, l.dateTime = ?3 where l.pk = ?1")
    Integer setLimitSum(LimitEntityPk pk, double limitSum, String dateTime);

    @Modifying
    @Query("update LimitEntity l set l.limitRemains = l.limitRemains - ?2 where l.pk = ?1")
    Integer changeLimitRemainder(LimitEntityPk pk, double spendAmount);

    @Modifying
    @Transactional
    @Query("update LimitEntity l set l.limitRemains = 0, l.limitSum = 0 where l.pk is not null")
    Integer dropMonthlyLimitValue();
}
