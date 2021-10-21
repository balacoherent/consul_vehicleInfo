package com.vehicleManagement.vehicleInfo.Repository;

import com.vehicleManagement.vehicleInfo.Entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer>{

    Page<Vehicle> searchAllByvehicleNameLike(String s, Pageable paging);
}
