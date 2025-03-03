package org.DJiLeaseMs.controller;

import org.DJiLeaseMs.common.constant.MessageConstant;
import org.DJiLeaseMs.common.result.Result;
import org.DJiLeaseMs.entity.Device;
import org.DJiLeaseMs.excption.BaseException;
import org.DJiLeaseMs.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    // 添加设备
    @PostMapping("/add")
    public Result<String> addDevice(@RequestBody Device device) {
        deviceService.addDevice(device);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 删除设备
    @DeleteMapping("/del/{id}")
    public Result<String> deleteDevice(@PathVariable Integer id) {
        deviceService.deleteDevice(id);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 更新设备
    @PutMapping("/update")
    public Result<String> updateDevice(@RequestBody Device device) {
        deviceService.updateDevice(device);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }

    // 根据ID查询设备
    @GetMapping("getById/{id}")
    public Result<Device> getDeviceById(@PathVariable Integer id) {
        Device device = deviceService.getDeviceById(id);
        return Result.success(MessageConstant.OPERATE_SUCCESS, device);
    }



    // 查询所有设备
    @GetMapping("/getAll")
    public Result<List<Device>> getAllDevices() {
        List<Device> list = deviceService.getAllDevices();
        return Result.success(MessageConstant.OPERATE_SUCCESS, list);
    }


    // 异常处理
    @ExceptionHandler(BaseException.class)
    public Result<String> handleBaseException(BaseException e) {
        return Result.error(e.getMessage());
    }
}
