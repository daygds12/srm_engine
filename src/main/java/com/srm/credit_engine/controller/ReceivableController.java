package com.srm.credit_engine.controller;

import com.srm.credit_engine.dto.ReceivableRequest;
import com.srm.credit_engine.dto.ReceivableResponse;
import com.srm.credit_engine.service.ReceivableService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receivables")
@RequiredArgsConstructor
public class ReceivableController {

    private final ReceivableService receivableService;

    @PostMapping
    public ResponseEntity<ReceivableResponse> create(
            @RequestBody @Valid ReceivableRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(receivableService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ReceivableResponse>> findAll() {
        return ResponseEntity.ok(receivableService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceivableResponse> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(receivableService.findById(id));
    }
}