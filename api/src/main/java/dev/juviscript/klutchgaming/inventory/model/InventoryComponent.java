package dev.juviscript.klutchgaming.inventory.model;

import dev.juviscript.klutchgaming.common.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "inventory_components")
@Data
@EqualsAndHashCode(callSuper = true)
public class InventoryComponent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String componentName;

    @NotNull
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @Nullable
    private Vendor vendor;

    @Nullable
    private String vendorProductUrl;

    @Nullable
    private String unit;
}