package com.example.tz.dao.repos;

import com.example.tz.dao.entities.LimitEntityPk;
import com.example.tz.dao.entities.TransactionEntity;
import com.example.tz.web.LimitExceededTransactionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.TypedQuery;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query(name = "get_limit_exceeded_transactions", nativeQuery = true)
    List<LimitExceededTransactionDto> getLimitExceededTransactions(@Param("bankAccount") Long bankAccount);

}
