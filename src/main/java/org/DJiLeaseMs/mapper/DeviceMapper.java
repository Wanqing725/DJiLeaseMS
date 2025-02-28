package org.DJiLeaseMs.mapper;

import org.DJiLeaseMs.entity.Device;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper {

    // 添加设备
    @Insert("INSERT INTO device (serial_number, model, color, purchase_price, daily_rent, status, last_check_time, check_notes, insurance_date, created_at, updated_at) " +
            "VALUES (#{serialNumber}, #{model}, #{color}, #{purchasePrice}, #{dailyRent}, #{status}, #{lastCheckTime}, #{checkNotes}, #{insuranceDate}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addDevice(Device device);

    // 删除设备
    @Delete("DELETE FROM device WHERE id = #{id}")
    void deleteDevice(Integer id);

    // 更新设备
    @Update("UPDATE device SET " +
            "serial_number = #{serialNumber}, " +
            "model = #{model}, " +
            "color = #{color}, " +
            "purchase_price = #{purchasePrice}, " +
            "daily_rent = #{dailyRent}, " +
            "status = #{status}, " +
            "last_check_time = #{lastCheckTime}, " +
            "check_notes = #{checkNotes}, " +
            "insurance_date = #{insuranceDate}, " +
            "updated_at = #{updatedAt} " +
            "WHERE id = #{id}")
    void updateDevice(Device device);

    // 根据ID查询设备
    @Select("SELECT * FROM device WHERE id = #{id}")
    Device getDeviceById(Integer id);

    // 查询所有设备
    @Select("SELECT * FROM device")
    List<Device> getAllDevices();
}