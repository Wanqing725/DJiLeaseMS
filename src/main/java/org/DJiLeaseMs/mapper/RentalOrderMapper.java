package org.DJiLeaseMs.mapper;

import org.DJiLeaseMs.entity.RentalOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RentalOrderMapper {

    // 添加租赁订单
    @Insert("INSERT INTO rental_order (order_number, customer_id, order_status, shipping_fee, total_amount, tracking_number, start_date, end_date, actual_return_date, created_at, updated_at) " +
            "VALUES (#{orderNumber}, #{customer.id}, #{orderStatus}, #{shippingFee}, #{totalAmount}, #{trackingNumber}, #{startDate}, #{endDate}, #{actualReturnDate}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addRentalOrder(RentalOrder rentalOrder);

    // 删除租赁订单
    @Delete("DELETE FROM rental_order WHERE id = #{id}")
    void deleteRentalOrder(Integer id);

    // 更新租赁订单
    @Update("UPDATE rental_order SET " +
            "order_number = #{orderNumber}, " +
            "customer_id = #{customer.id}, " +
            "order_status = #{orderStatus}, " +
            "shipping_fee = #{shippingFee}, " +
            "total_amount = #{totalAmount}, " +
            "tracking_number = #{trackingNumber}, " +
            "start_date = #{startDate}, " +
            "end_date = #{endDate}, " +
            "actual_return_date = #{actualReturnDate}, " +
            "updated_at = #{updatedAt} " +
            "WHERE id = #{id}")
    void updateRentalOrder(RentalOrder rentalOrder);

    // 根据ID查询租赁订单
    @Select("SELECT * FROM rental_order WHERE id = #{id}")
    RentalOrder getRentalOrderById(Integer id);

    // 查询所有租赁订单
    @Select("SELECT * FROM rental_order")
    List<RentalOrder> getAllRentalOrders();

    @Select("SELECT * FROM rental_order WHERE order_status = #{status}")
    List<RentalOrder> getRentalOrderByStatus(String status);
}
