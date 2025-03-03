package org.DJiLeaseMs.controller;

import org.DJiLeaseMs.common.constant.MessageConstant;
import org.DJiLeaseMs.common.result.Result;
import org.DJiLeaseMs.entity.Customer;
import org.DJiLeaseMs.excption.BaseException;
import org.DJiLeaseMs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // 添加客户
    @PostMapping("/add")
    public Result<String> addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 删除客户
    @DeleteMapping("/del/{id}")
    public Result<String> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 更新客户
    @PutMapping("/update")
    public Result<String> updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 根据ID查询客户
    @GetMapping("/select/{id}")
    public Result<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        return Result.success(MessageConstant.OPERATE_SUCCESS, customer);
    }

    // 查询所有客户
    @GetMapping("/getAll")
    public Result<List<Customer>> getAllCustomers() {
        List<Customer> list = customerService.getAllCustomers();
        return Result.success(MessageConstant.OPERATE_SUCCESS, list);
    }

    // 异常处理
    @ExceptionHandler(BaseException.class)
    public Result<String> handleBaseException(BaseException e) {
        return Result.error(e.getMessage());
    }
}
