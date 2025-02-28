package org.DJiLeaseMs.service;

import org.DJiLeaseMs.entity.RentalOrder;

import java.util.List;

public interface RentalOrderService {
    void addRentalOrder(RentalOrder rentalOrder);
    void deleteRentalOrder(Integer id);
    void updateRentalOrder(RentalOrder rentalOrder);
    RentalOrder getRentalOrderById(Integer id);
    List<RentalOrder> getAllRentalOrders();
}
