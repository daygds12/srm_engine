package com.srm.credit_engine.service;

import java.util.List;
import com.srm.credit_engine.dto.ReceivableRequest;
import com.srm.credit_engine.dto.ReceivableResponse;
import com.srm.credit_engine.entity.Currency;
import com.srm.credit_engine.entity.Receivable;
import com.srm.credit_engine.repository.CurrencyRepository;
import com.srm.credit_engine.repository.ReceivableRepository;
import com.srm.credit_engine.strategy.PricingStrategy;
import com.srm.credit_engine.strategy.PricingStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceivableService {

    private final ReceivableRepository receivableRepository;
    private final CurrencyRepository currencyRepository;
    private final PricingStrategyFactory pricingStrategyFactory;


    public ReceivableResponse create(ReceivableRequest request) {

        Currency currency = currencyRepository
                .findByCode(request.currencyCode())
                .orElseThrow(() -> new RuntimeException("Currency not found"));


        PricingStrategy strategy =
                pricingStrategyFactory.getStrategy(request.type());


        var presentValue = strategy.calculate(
                request.faceValue(),
                request.term()
        );


        Receivable receivable = new Receivable();

        receivable.setFaceValue(request.faceValue());
        receivable.setTerm(request.term());
        receivable.setType(request.type());
        receivable.setCurrency(currency);
        receivable.setPresentValue(presentValue);


        Receivable saved = receivableRepository.save(receivable);


        return new ReceivableResponse(
                saved.getId(),
                saved.getFaceValue(),
                saved.getPresentValue(),
                saved.getTerm(),
                saved.getType(),
                saved.getCurrency().getCode()
        );
    }

    public List<ReceivableResponse> findAll() {

        return receivableRepository.findAll()
                .stream()
                .map(receivable -> new ReceivableResponse(
                        receivable.getId(),
                        receivable.getFaceValue(),
                        receivable.getPresentValue(),
                        receivable.getTerm(),
                        receivable.getType(),
                        receivable.getCurrency().getCode()
                ))
                .toList();
    }

    public ReceivableResponse findById(Long id) {

        Receivable receivable = receivableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receivable not found"));

        return new ReceivableResponse(
                receivable.getId(),
                receivable.getFaceValue(),
                receivable.getPresentValue(),
                receivable.getTerm(),
                receivable.getType(),
                receivable.getCurrency().getCode()
        );
    }
}