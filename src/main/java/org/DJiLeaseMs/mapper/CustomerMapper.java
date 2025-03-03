package org.DJiLeaseMs.mapper;

import org.DJiLeaseMs.entity.Customer;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface CustomerMapper {
    // 添加客户
    @Insert("INSERT INTO customer (name, address, phone, xianyu_id, created_at, updated_at) " +
            "VALUES (#{name}, #{address}, #{phone}, #{xianyuId}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addCustomer(Customer customer);

    // 删除客户
    @Delete("DELETE FROM customer WHERE id = #{id}")
    void deleteCustomer(Integer id);

    // 更新客户
    void updateCustomer(Customer customer);

    // 根据ID查询客户
    @Select("SELECT * FROM customer WHERE id = #{id}")
    Customer getCustomerById(Integer id);

    // 查询所有客户
    @Select("SELECT * FROM customer")
    List<Customer> getAllCustomers();
}
