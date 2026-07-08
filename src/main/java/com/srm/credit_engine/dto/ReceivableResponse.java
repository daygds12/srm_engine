package com.srm.credit_engine.dto;

import com.srm.credit_engine.enums.ReceivableType;

import java.math.BigDecimal;

public record ReceivableResponse(

        Long id,

        BigDecimal faceValue,

        BigDecimal presentValue,

        Integer term,

        ReceivableType type,

        String currencyCode


) {
}
