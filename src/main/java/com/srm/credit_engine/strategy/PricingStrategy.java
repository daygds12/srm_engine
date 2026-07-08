package com.srm.credit_engine.strategy;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculate(
            BigDecimal faceValue,
            Integer term
    );
}
