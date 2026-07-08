package com.srm.credit_engine.repository;

import com.srm.credit_engine.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository
        extends JpaRepository<ExchangeRate, Long> {

}
