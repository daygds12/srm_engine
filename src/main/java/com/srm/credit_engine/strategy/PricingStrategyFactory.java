package com.srm.credit_engine.strategy;

import com.srm.credit_engine.enums.ReceivableType;
import org.springframework.stereotype.Component;

@Component
public class PricingStrategyFactory {

    private final DuplicateStrategy duplicateStrategy;
    private final CheckStrategy checkStrategy;

    public PricingStrategyFactory(
            DuplicateStrategy duplicateStrategy,
            CheckStrategy checkStrategy) {

        this.duplicateStrategy = duplicateStrategy;
        this.checkStrategy = checkStrategy;
    }

    public PricingStrategy getStrategy(ReceivableType type) {

        return switch (type) {
            case DUPLICATE -> duplicateStrategy;
            case CHECK -> checkStrategy;
        };
    }
}
