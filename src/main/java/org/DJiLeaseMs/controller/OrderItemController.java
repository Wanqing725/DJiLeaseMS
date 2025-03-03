package org.DJiLeaseMs.controller;

import org.DJiLeaseMs.common.constant.MessageConstant;
import org.DJiLeaseMs.common.result.Result;
import org.DJiLeaseMs.entity.OrderItem;
import org.DJiLeaseMs.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    // 添加订单项
    @PostMapping("/add")
    public Result<String> addOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.addOrderItem(orderItem);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 删除订单项
    @DeleteMapping("/del/{id}")
    public Result<String> deleteOrderItem(@PathVariable Integer id) {
        orderItemService.deleteOrderItem(id);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 更新订单项
    @PutMapping("/update")
    public Result<String> updateOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.updateOrderItem(orderItem);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 根据ID查询订单项
    @GetMapping("/getById/{id}")
    public Result<OrderItem> getOrderItemById(@PathVariable Integer id) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        return Result.success(MessageConstant.OPERATE_SUCCESS, orderItem);
    }

    // 查询所有订单项
    @GetMapping("/getAll")
    public Result<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> list = orderItemService.getAllOrderItems();
        return Result.success(MessageConstant.OPERATE_SUCCESS, list);
    }
}