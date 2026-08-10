package dev.juviscript.klutchgaming.orders;

import dev.juviscript.klutchgaming.orders.model.Order;
import dev.juviscript.klutchgaming.orders.model.OrderItem;
import dev.juviscript.klutchgaming.orders.model.OrderStatusHistory;
import dev.juviscript.klutchgaming.orders.repository.OrderItemRepository;
import dev.juviscript.klutchgaming.orders.repository.OrderRepository;
import dev.juviscript.klutchgaming.orders.repository.OrderStatusHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderStatusHistoryRepository orderStatusHistoryRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateStatus(Long orderId, String newStatus, Long changedBy, String changedSource) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));

        order.setStatus(newStatus);
        orderRepository.save(order);

        OrderStatusHistory history = new OrderStatusHistory();
        history.setOrder(order);
        history.setStatus(newStatus);
        history.setChangedAt(LocalDateTime.now());
        history.setChangedSource(changedSource);
        orderStatusHistoryRepository.save(history);

        return order;
    }

    public List<OrderItem> getOrderItems(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    public OrderItem createOrderItem(OrderItem item) {
        return orderItemRepository.save(item);
    }

    public List<OrderStatusHistory> getStatusHistory(Long orderId) {
        return orderStatusHistoryRepository.findByOrderId(orderId);
    }

    public void deleteOrder(Long id) {
        orderRepository.findById(id).ifPresent(order -> {
            order.setDeletedAt(LocalDateTime.now());
            orderRepository.save(order);
        });
    }
}
