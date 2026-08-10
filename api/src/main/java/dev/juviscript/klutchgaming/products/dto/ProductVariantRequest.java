package dev.juviscript.klutchgaming.products.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductVariantRequest(
        @NotBlank String variantName,
        String color,
        String size,
        @NotNull @Positive BigDecimal price,
        @Min(0) int stockQuantity
) {}
