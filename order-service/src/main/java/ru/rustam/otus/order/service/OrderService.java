package ru.rustam.otus.order.service;

import ru.rustam.otus.order.db.OrderEntity;

public interface OrderService {

    OrderEntity createOrder(OrderEntity order);

    OrderEntity getOrder(Long orderId);

    void deleteOrder(Long orderId);

    void updateOrder(Long orderId, OrderEntity order);

    void updateOrderStatus(Long orderId, String newStatus);

}
