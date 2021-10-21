package com.vehicleManagement.vehicleInfo.ServiceInterface;

import com.vehicleManagement.vehicleInfo.BaseResponse.PageResponse;
import com.vehicleManagement.vehicleInfo.DTO.VehicleDTO;
import com.vehicleManagement.vehicleInfo.Entity.Vehicle;

import java.util.Optional;

public interface VehicleInterfce {

    Vehicle addvehicle(VehicleDTO vehicleDTO);

    Optional<Vehicle> updatevehicle(VehicleDTO vehicleDTO);

    Optional<Vehicle> findvehicleById(int id);

    Vehicle deletevehicle(int id);

    PageResponse<Vehicle> vehiclePagination(int offset, int pageSize, String vehicleName);
}

