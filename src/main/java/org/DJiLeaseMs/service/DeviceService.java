package org.DJiLeaseMs.service;

import org.DJiLeaseMs.entity.Device;

import java.util.List;

public interface DeviceService {
    void addDevice(Device device);
    void deleteDevice(Integer id);
    void updateDevice(Device device);
    Device getDeviceById(Integer id);
    List<Device> getAllDevices();
}
