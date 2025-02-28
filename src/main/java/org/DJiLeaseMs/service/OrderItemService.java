package org.DJiLeaseMs.service;

import org.DJiLeaseMs.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    void addOrderItem(OrderItem orderItem);
    void deleteOrderItem(Integer id);
    void updateOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(Integer id);
    List<OrderItem> getAllOrderItems();
}
