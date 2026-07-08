package com.srm.credit_engine.service;

import com.srm.credit_engine.dto.ExchangeRateRequest;
import com.srm.credit_engine.dto.ExchangeRateResponse;
import com.srm.credit_engine.entity.Currency;
import com.srm.credit_engine.entity.ExchangeRate;
import com.srm.credit_engine.repository.CurrencyRepository;
import com.srm.credit_engine.repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import com.srm.credit_engine.dto.ExchangeRateRequest;
import com.srm.credit_engine.dto.ExchangeRateResponse;
import com.srm.credit_engine.entity.Currency;
import com.srm.credit_engine.entity.ExchangeRate;

import java.time.LocalDateTime;

@Service
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;
    private final CurrencyRepository currencyRepository;

    public ExchangeRateService(
            ExchangeRateRepository exchangeRateRepository,
            CurrencyRepository currencyRepository) {

        this.exchangeRateRepository = exchangeRateRepository;
        this.currencyRepository = currencyRepository;
    }

    public ExchangeRateResponse create(ExchangeRateRequest request) {

        Currency fromCurrency = currencyRepository.findByCode(request.fromCurrency())
                .orElseThrow(() -> new RuntimeException("Currency not found"));

        Currency toCurrency = currencyRepository.findByCode(request.toCurrency())
                .orElseThrow(() -> new RuntimeException("Currency not found"));

        ExchangeRate exchangeRate = new ExchangeRate();

        exchangeRate.setFromCurrency(fromCurrency);
        exchangeRate.setToCurrency(toCurrency);
        exchangeRate.setRate(request.rate());
        exchangeRate.setCreatedAt(LocalDateTime.now());

        ExchangeRate saved = exchangeRateRepository.save(exchangeRate);

        return new ExchangeRateResponse(
                saved.getId(),
                saved.getFromCurrency().getCode(),
                saved.getToCurrency().getCode(),
                saved.getRate()
        );

    }
}