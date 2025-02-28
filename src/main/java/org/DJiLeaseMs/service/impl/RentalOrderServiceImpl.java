package org.DJiLeaseMs.service.impl;

import org.DJiLeaseMs.entity.RentalOrder;
import org.DJiLeaseMs.mapper.RentalOrderMapper;
import org.DJiLeaseMs.service.RentalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalOrderServiceImpl implements RentalOrderService {

    @Autowired
    private RentalOrderMapper rentalOrderMapper;

    @Override
    public void addRentalOrder(RentalOrder rentalOrder) {
        // 设置 createdAt 和 updatedAt 为当前时间
        LocalDateTime now = LocalDateTime.now();
        rentalOrder.setCreatedAt(now);
        rentalOrder.setUpdatedAt(now);
        rentalOrderMapper.addRentalOrder(rentalOrder);
    }

    @Override
    public void deleteRentalOrder(Integer id) {
        rentalOrderMapper.deleteRentalOrder(id);
    }

    @Override
    public void updateRentalOrder(RentalOrder rentalOrder) {
        // 更新 updated_at 为当前时间
        rentalOrder.setUpdatedAt(LocalDateTime.now());
        rentalOrderMapper.updateRentalOrder(rentalOrder);
    }

    @Override
    public RentalOrder getRentalOrderById(Integer id) {
        return rentalOrderMapper.getRentalOrderById(id);
    }

    @Override
    public List<RentalOrder> getAllRentalOrders() {
        return rentalOrderMapper.getAllRentalOrders();
    }
}
