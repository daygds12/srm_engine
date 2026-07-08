package com.srm.credit_engine.controller;

import com.srm.credit_engine.dto.CurrencyRequestDTO;
import com.srm.credit_engine.dto.CurrencyResponseDTO;
import com.srm.credit_engine.service.CurrencyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CurrencyResponseDTO create(@Valid @RequestBody CurrencyRequestDTO request) {

        System.out.println(request);

        return service.create(request);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrencyResponseDTO> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CurrencyResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurrencyResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody CurrencyRequestDTO request
    ) {

        return ResponseEntity.ok(service.update(id, request));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
