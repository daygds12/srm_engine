package com.srm.credit_engine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CurrencyRequestDTO(


        @NotBlank
        @Size(min = 3, max = 3)
        String code,

        @NotBlank
        String description
) {



}