package com.srm.credit_engine.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DuplicateStrategy implements PricingStrategy {

    @Override
    public BigDecimal calculate(BigDecimal faceValue, Integer term) {

        BigDecimal spread = new BigDecimal("0.015");
        BigDecimal taxaBase = new BigDecimal("0.01");

        return faceValue.divide(
                BigDecimal.ONE.add(taxaBase).add(spread),
                2,
                RoundingMode.HALF_UP
        );

    }
}
