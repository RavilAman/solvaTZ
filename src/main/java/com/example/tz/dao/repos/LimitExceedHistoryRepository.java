package com.example.tz.dao.repos;

import com.example.tz.dao.entities.LimitExceedHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitExceedHistoryRepository extends JpaRepository<LimitExceedHistoryEntity, Long> {
}
