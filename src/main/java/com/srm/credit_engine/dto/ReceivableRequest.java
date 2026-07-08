package com.srm.credit_engine.dto;

import com.srm.credit_engine.enums.ReceivableType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ReceivableRequest(
        @NotNull
        BigDecimal faceValue,

        @NotNull
        Integer term,

        @NotNull
        ReceivableType type,

        @NotNull
        String currencyCode

) {
}
