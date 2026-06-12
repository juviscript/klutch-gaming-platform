package dev.juviscript.klutchgaming.orders.model;

import dev.juviscript.klutchgaming.common.BaseEntity;
import dev.juviscript.klutchgaming.users.model.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Nullable
    private User user;

    @NotNull
    private BigDecimal totalPrice;

    @NotNull private String shippingAddressLine1;
    @Nullable private String shippingAddressLine2;
    @NotNull private String shippingCity;
    @NotNull private String shippingState;
    @NotNull private String shippingZip;

    @NotNull private String billingAddressLine1;
    @Nullable private String billingAddressLine2;
    @NotNull private String billingCity;
    @NotNull private String billingState;
    @NotNull private String billingZip;

    @NotNull
    private String status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "order")
    private List<OrderStatusHistory> statusHistory;
}