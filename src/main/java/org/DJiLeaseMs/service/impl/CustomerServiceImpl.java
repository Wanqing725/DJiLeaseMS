package org.DJiLeaseMs.service.impl;

import org.DJiLeaseMs.entity.Customer;
import org.DJiLeaseMs.entity.Device;
import org.DJiLeaseMs.excption.BaseException;
import org.DJiLeaseMs.mapper.CustomerMapper;
import org.DJiLeaseMs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void addCustomer(Customer customer) {
        // 设置 createdAt 和 updatedAt 为当前时间
        LocalDateTime now = LocalDateTime.now();
        customer.setCreatedAt(now);
        customer.setUpdatedAt(now);
        customerMapper.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerMapper.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (customer.getId() == null) {
            throw new BaseException("id不能为空");
        }

        // 检查设备是否存在
        Customer existingDevice = customerMapper.getCustomerById(customer.getId());
        if (existingDevice == null) {
            throw new BaseException("该客户不存在，无法更新");
        }

        // 更新 updated_at 为当前时间
        customer.setUpdatedAt(LocalDateTime.now());
        customerMapper.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerMapper.getAllCustomers();
    }
}
