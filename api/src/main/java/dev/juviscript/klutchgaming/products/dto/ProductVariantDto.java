package dev.juviscript.klutchgaming.products.dto;

import dev.juviscript.klutchgaming.products.model.ProductVariant;

import java.math.BigDecimal;

public record ProductVariantDto(
        Long id,
        Long productId,
        String variantName,
        String color,
        String size,
        BigDecimal price,
        int stockQuantity
) {
    public static ProductVariantDto from(ProductVariant v) {
        return new ProductVariantDto(
                v.getId(),
                v.getProduct().getId(),
                v.getVariantName(),
                v.getColor(),
                v.getSize(),
                v.getPrice(),
                v.getStockQuantity()
        );
    }
}
