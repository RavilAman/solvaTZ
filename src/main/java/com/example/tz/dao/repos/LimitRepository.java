package com.example.tz.dao.repos;

import com.example.tz.dao.entities.LimitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LimitRepository extends JpaRepository<LimitEntity, String> {

    @Modifying
    @Query("update LimitEntity l set l.limitRemains = l.limitRemains + ?2 - l.limitSum, l.limitSum = ?2, l.dateTime = ?3 where l.limitType = ?1")
    Integer setLimitSum(String limitType, double limitSum, String dateTime);

    @Modifying
    @Query("update LimitEntity l set l.limitRemains = l.limitRemains - ?2 where l.limitType = ?1")
    Integer changeLimitRemainder(String limitType, double spendAmount);
}
