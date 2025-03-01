package org.DJiLeaseMs.service;

import org.DJiLeaseMs.entity.RentalOrder;

import java.util.List;

public interface RentalOrderService {
    // 添加租赁订单
    void addRentalOrder(RentalOrder rentalOrder);

    // 删除租赁订单
    void deleteRentalOrder(Integer id);

    // 更新租赁订单
    void updateRentalOrder(RentalOrder rentalOrder);

    // 根据ID查询租赁订单
    RentalOrder getRentalOrderById(Integer id);

    // 查询所有租赁订单
    List<RentalOrder> getAllRentalOrders();

    /**
     * 根据订单状态查询
     * @param status 订单状态
     * @return 符合条件的订单列表
     */
    List<RentalOrder> getRentalOrderByStatus(String status);
}
