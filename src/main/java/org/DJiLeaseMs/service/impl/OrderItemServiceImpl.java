package org.DJiLeaseMs.service.impl;

import org.DJiLeaseMs.entity.OrderItem;
import org.DJiLeaseMs.mapper.OrderItemMapper;
import org.DJiLeaseMs.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void addOrderItem(OrderItem orderItem) {
        // 设置 createdAt 和 updatedAt 为当前时间
        LocalDateTime now = LocalDateTime.now();
        orderItem.setCreatedAt(now);
        orderItem.setUpdatedAt(now);
        orderItemMapper.addOrderItem(orderItem);
    }

    @Override
    public void deleteOrderItem(Integer id) {
        orderItemMapper.deleteOrderItem(id);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        // 更新 updated_at 为当前时间
        orderItem.setUpdatedAt(LocalDateTime.now());
        orderItemMapper.updateOrderItem(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(Integer id) {
        return orderItemMapper.getOrderItemById(id);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemMapper.getAllOrderItems();
    }
}