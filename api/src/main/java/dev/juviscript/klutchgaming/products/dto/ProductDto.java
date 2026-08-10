package dev.juviscript.klutchgaming.products.dto;

import dev.juviscript.klutchgaming.products.model.Product;

import java.math.BigDecimal;

public record ProductDto(
        Long id,
        String name,
        String description,
        String descriptionHtml,
        BigDecimal price,
        boolean isComponentAssembled,
        boolean isActive
) {
    public static ProductDto from(Product p) {
        return new ProductDto(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getDescriptionHtml(),
                p.getPrice(),
                p.isComponentAssembled(),
                p.isActive()
        );
    }
}
