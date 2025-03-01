package org.DJiLeaseMs.service.impl;

import org.DJiLeaseMs.common.constant.MessageConstant;
import org.DJiLeaseMs.common.result.Result;
import org.DJiLeaseMs.entity.RentalOrder;
import org.DJiLeaseMs.excption.BaseException;
import org.DJiLeaseMs.mapper.RentalOrderMapper;
import org.DJiLeaseMs.service.RentalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalOrderServiceImpl implements RentalOrderService {

    @Autowired
    private RentalOrderMapper rentalOrderMapper;

    // 添加租赁订单
    public void addRentalOrder(RentalOrder rentalOrder) {
        // 设置 createdAt 和 updatedAt 为当前时间
        LocalDateTime now = LocalDateTime.now();
        rentalOrder.setCreatedAt(now);
        rentalOrder.setUpdatedAt(now);
        rentalOrderMapper.addRentalOrder(rentalOrder);
    }

    // 删除租赁订单
    public void deleteRentalOrder(Integer id) {
        rentalOrderMapper.deleteRentalOrder(id);
    }

    // 更新租赁订单
    public void updateRentalOrder(RentalOrder rentalOrder) {
        // 更新 updated_at 为当前时间
        rentalOrder.setUpdatedAt(LocalDateTime.now());
        rentalOrderMapper.updateRentalOrder(rentalOrder);
    }

    // 根据ID查询租赁订单
    public RentalOrder getRentalOrderById(Integer id) {
        return rentalOrderMapper.getRentalOrderById(id);
    }

    // 查询所有租赁订单
    public List<RentalOrder> getAllRentalOrders() {
        return rentalOrderMapper.getAllRentalOrders();
    }

    @Override
    public List<RentalOrder> getRentalOrderByStatus(String status) {
        return rentalOrderMapper.getRentalOrderByStatus(status);
    }

    @Override
    public void updateOrderStatus(Integer id, String status) {
        // 检查订单是否存在
        RentalOrder rentalOrder = rentalOrderMapper.getRentalOrderById(id);
        if(rentalOrder == null){
            throw new BaseException(MessageConstant.ORDER_IS_NOT_EXIST);
        }
        rentalOrderMapper.updateStatusById(id, status);
    }
}
