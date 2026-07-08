package com.srm.credit_engine.mapper;

import com.srm.credit_engine.dto.CurrencyRequestDTO;
import com.srm.credit_engine.dto.CurrencyResponseDTO;
import com.srm.credit_engine.entity.Currency;

public class CurrencyMapper {

    public Currency toEntity(CurrencyRequestDTO dto) {

        Currency currency = new Currency();

        currency.setCode(dto.code());
        currency.setDescription(dto.description());

        return currency;
    }

    public CurrencyResponseDTO toDTO(Currency currency) {

        return new CurrencyResponseDTO(
                currency.getId(),
                currency.getCode(),
                currency.getDescription()
        );
    }
}
