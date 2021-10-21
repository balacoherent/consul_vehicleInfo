package com.vehicleManagement.vehicleInfo.ServiceInterface;

import com.vehicleManagement.vehicleInfo.DTO.VehicleTypeDTO;
import com.vehicleManagement.vehicleInfo.Entity.VehicleType;

import java.util.List;
import java.util.Optional;

public interface VehicleTypeInterface {

    VehicleType addvehicleType(VehicleTypeDTO vehicleTypeDTO);

    Optional<VehicleType> updatevehicleType(VehicleTypeDTO vehicleTypeDTO);

    VehicleType deletevehicleType(int id);

    List<VehicleType> listAll();
}
