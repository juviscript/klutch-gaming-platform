package dev.juviscript.klutchgaming.shipments.model;

import dev.juviscript.klutchgaming.common.BaseEntity;
import dev.juviscript.klutchgaming.orders.model.Order;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipments")
@Data
@EqualsAndHashCode(callSuper = true)
public class Shipment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable private String carrier;

    @Nullable private String trackingNumber;

    @Nullable private String labelUrl;

    @Nullable private LocalDateTime shippedAt;

    @Nullable private LocalDateTime deliveredAt;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}