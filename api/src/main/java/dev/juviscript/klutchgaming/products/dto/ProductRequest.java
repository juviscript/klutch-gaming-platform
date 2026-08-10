package dev.juviscript.klutchgaming.products.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank String name,
        String description,
        String descriptionHtml,
        @NotNull @Positive BigDecimal price,
        boolean isComponentAssembled
) {}
