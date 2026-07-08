package com.srm.credit_engine.dto;

import java.math.BigDecimal;

public record ExchangeRateRequest(

        String fromCurrency,

        String toCurrency,

        BigDecimal rate

){}

