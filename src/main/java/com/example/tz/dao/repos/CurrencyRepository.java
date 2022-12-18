package com.example.tz.dao.repos;

import com.example.tz.dao.entities.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {


    @Modifying
    @Query("update CurrencyEntity c set c.previousClose = c.close, c.close = ?2 where c.currencyType = ?1")
    Integer setCurrency(String currencyType, double currency);

    CurrencyEntity getCurrencyEntityByCurrencyType(String currencyType);
}
