package dev.juviscript.klutchgaming.products.model;

import dev.juviscript.klutchgaming.common.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "product_variants")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductVariant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String variantName;

    @Nullable
    private String color;

    @Nullable
    private String size;

    @NotNull
    private BigDecimal price;

    @NotNull
    private int stockQuantity;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
