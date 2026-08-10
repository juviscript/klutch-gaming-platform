package dev.juviscript.klutchgaming.inventory.model;

import dev.juviscript.klutchgaming.common.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

    @Nullable
    private String vendorProductUrl;

    @Nullable
    private String unit;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @Nullable
    private Vendor vendor;
}