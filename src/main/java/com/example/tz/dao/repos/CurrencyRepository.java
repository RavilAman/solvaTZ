package com.example.tz.dao.repos;

import com.example.tz.dao.entities.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {

    @Modifying
    @Transactional
    @Query("update CurrencyEntity c set c.close = ?2 where c.currencyType = ?1")
    Integer setCurrency(String currencyType, double currency);

    CurrencyEntity getCurrencyEntityByCurrencyType(String currencyType);
}
