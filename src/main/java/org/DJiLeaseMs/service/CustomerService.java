package org.DJiLeaseMs.service;

import org.DJiLeaseMs.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    void deleteCustomer(Integer id);
    void updateCustomer(Customer customer);
    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
}
