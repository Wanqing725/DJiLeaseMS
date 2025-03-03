package org.DJiLeaseMs.service.impl;

import org.DJiLeaseMs.entity.Device;
import org.DJiLeaseMs.excption.BaseException;
import org.DJiLeaseMs.mapper.DeviceMapper;
import org.DJiLeaseMs.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public void addDevice(Device device) {
        // 设置 createdAt 和 updatedAt 为当前时间
        LocalDateTime now = LocalDateTime.now();
        device.setCreatedAt(now);
        device.setUpdatedAt(now);
        deviceMapper.addDevice(device);
    }

    @Override
    public void deleteDevice(Integer id) {
        deviceMapper.deleteDevice(id);
    }

    @Override
    public void updateDevice(Device device) {
        if(device.getId() == null){
            throw new BaseException("id不能为空");
        }

        // 检查设备是否存在
        Device existingDevice = deviceMapper.getDeviceById(device.getId());
        if (existingDevice == null) {
            throw new BaseException("设备不存在，无法更新");
        }

        // 更新 updated_at 为当前时间
        device.setUpdatedAt(LocalDateTime.now());
        deviceMapper.updateDevice(device);
    }

    @Override
    public Device getDeviceById(Integer id) {
        return deviceMapper.getDeviceById(id);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceMapper.getAllDevices();
    }
}