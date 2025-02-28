package org.DJiLeaseMs.mapper;

import org.DJiLeaseMs.entity.OrderItem;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderItemMapper {

    // 添加订单项
    @Insert("INSERT INTO order_item (order_id, device_id, daily_rent, calculated_days, subtotal, created_at, updated_at) " +
            "VALUES (#{orderId}, #{deviceId}, #{dailyRent}, #{calculatedDays}, #{subtotal}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addOrderItem(OrderItem orderItem);

    // 删除订单项
    @Delete("DELETE FROM order_item WHERE id = #{id}")
    void deleteOrderItem(Integer id);

    // 更新订单项
    @Update("UPDATE order_item SET " +
            "order_id = #{orderId}, " +
            "device_id = #{deviceId}, " +
            "daily_rent = #{dailyRent}, " +
            "calculated_days = #{calculatedDays}, " +
            "subtotal = #{subtotal}, " +
            "updated_at = #{updatedAt} " +
            "WHERE id = #{id}")
    void updateOrderItem(OrderItem orderItem);

    // 根据ID查询订单项
    @Select("SELECT * FROM order_item WHERE id = #{id}")
    OrderItem getOrderItemById(Integer id);

    // 查询所有订单项
    @Select("SELECT * FROM order_item")
    List<OrderItem> getAllOrderItems();
}
