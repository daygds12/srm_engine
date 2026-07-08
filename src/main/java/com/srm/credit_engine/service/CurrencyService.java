package com.srm.credit_engine.service;

import com.srm.credit_engine.dto.CurrencyRequestDTO;
import com.srm.credit_engine.dto.CurrencyResponseDTO;
import com.srm.credit_engine.entity.Currency;
import com.srm.credit_engine.repository.CurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository repository;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public CurrencyResponseDTO findById(Long id) {

        Currency currency = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currency not found"));

        return new CurrencyResponseDTO(
                currency.getId(),
                currency.getCode(),
                currency.getDescription()
        );
    }

    @Transactional
    public CurrencyResponseDTO create(CurrencyRequestDTO request) {

        repository.findByCode(request.code())
                .ifPresent(currency -> {
                    throw new RuntimeException("Currency already exists");
                });

        Currency currency = new Currency();
        currency.setCode(request.code());
        currency.setDescription(request.description());

        Currency savedCurrency = repository.save(currency);

        return new CurrencyResponseDTO(
                savedCurrency.getId(),
                savedCurrency.getCode(),
                savedCurrency.getDescription()
        );
    }

    public List<CurrencyResponseDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(currency -> new CurrencyResponseDTO(
                        currency.getId(),
                        currency.getCode(),
                        currency.getDescription()
                ))
                .toList();
    }

    @Transactional
    public CurrencyResponseDTO update(Long id, CurrencyRequestDTO request) {

        Currency currency = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currency not found"));

        currency.setCode(request.code());
        currency.setDescription(request.description());

        Currency updatedCurrency = repository.save(currency);

        return new CurrencyResponseDTO(
                updatedCurrency.getId(),
                updatedCurrency.getCode(),
                updatedCurrency.getDescription()
        );
    }
    @Transactional
    public void delete(Long id) {

        Currency currency = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currency not found"));

        repository.delete(currency);
    }



}