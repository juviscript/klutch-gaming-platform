package dev.juviscript.klutchgaming.products.model;

import dev.juviscript.klutchgaming.common.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Nullable
    private String description;

    @Nullable
    private String descriptionHtml;

    @NotNull
    private BigDecimal price;

    private boolean isComponentAssembled;
    private boolean isActive;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "product")
    private List<ProductVariant> productVariants;
}
