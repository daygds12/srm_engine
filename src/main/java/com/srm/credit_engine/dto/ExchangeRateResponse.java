package com.srm.credit_engine.dto;

import java.math.BigDecimal;

public record ExchangeRateResponse(
        Long id,

        String fromCurrency,

        String toCurrency,

        BigDecimal rate

){}

