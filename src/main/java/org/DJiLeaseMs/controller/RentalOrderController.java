package org.DJiLeaseMs.controller;

import org.DJiLeaseMs.common.constant.MessageConstant;
import org.DJiLeaseMs.common.result.Result;
import org.DJiLeaseMs.entity.RentalOrder;
import org.DJiLeaseMs.service.RentalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rentalOrders")
public class RentalOrderController {

    @Autowired
    private RentalOrderService rentalOrderService;

    // 添加租赁订单
    @PostMapping("/api/add")
    public Result<String> addRentalOrder(@RequestBody RentalOrder rentalOrder) {
        rentalOrderService.addRentalOrder(rentalOrder);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 删除租赁订单
    @DeleteMapping("/del/{id}")
    public Result<String> deleteRentalOrder(@PathVariable Integer id) {
        rentalOrderService.deleteRentalOrder(id);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 更新租赁订单
    @PutMapping("/update")
    public Result<String> updateRentalOrder(@RequestBody RentalOrder rentalOrder) {
        rentalOrderService.updateRentalOrder(rentalOrder);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 根据ID查询租赁订单
    @GetMapping("/getById/{id}")
    public Result<RentalOrder> getRentalOrderById(@PathVariable Integer id) {
        RentalOrder rentalOrder = rentalOrderService.getRentalOrderById(id);
        return Result.success(MessageConstant.OPERATE_SUCCESS, rentalOrder);
    }

    /**
     * 根据点单状态查询
     * @param status 订单状态
     * @return 查询结果
     */
    @GetMapping("/getByStatus/{status}")
    public Result<List<RentalOrder>> getRentalOrderByStatus(@PathVariable String status) {
        List<RentalOrder> list = rentalOrderService.getRentalOrderByStatus(status);
        return Result.success(MessageConstant.OPERATE_SUCCESS, list);
    }

    // 查询所有租赁订单
    @GetMapping("/getAll")
    public Result<List<RentalOrder>> getAll(){
        List<RentalOrder> list = rentalOrderService.getAllRentalOrders();
        return Result.success(MessageConstant.OPERATE_SUCCESS,list);
    }

    /**
     * 修改订单状态
     * @param id 订单ID
     * @param status 新的状态值
     * @return 操作结果
     */
    @PutMapping("/updateStatus/{id}")
    public Result<String> updateOrderStatus(@PathVariable Integer id, @RequestParam String status) {
        rentalOrderService.updateOrderStatus(id, status);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }
}
