package com.srm.credit_engine.strategy;

import com.srm.credit_engine.enums.ReceivableType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CheckStrategy implements PricingStrategy {

    @Override
    public BigDecimal calculate(BigDecimal faceValue, Integer term) {
        return faceValue.multiply(BigDecimal.valueOf(0.95));
    }
}