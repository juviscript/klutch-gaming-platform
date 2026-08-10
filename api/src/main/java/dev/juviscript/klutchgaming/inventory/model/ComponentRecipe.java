package dev.juviscript.klutchgaming.inventory.model;

import dev.juviscript.klutchgaming.common.BaseEntity;
import dev.juviscript.klutchgaming.products.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "component_recipe")
@Data
@EqualsAndHashCode(callSuper = true)
public class ComponentRecipe extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer quantity;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private InventoryComponent component;
}