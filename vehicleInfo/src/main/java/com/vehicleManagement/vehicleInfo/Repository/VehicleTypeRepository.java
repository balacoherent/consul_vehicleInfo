package com.vehicleManagement.vehicleInfo.Repository;

import com.vehicleManagement.vehicleInfo.Entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {
}
