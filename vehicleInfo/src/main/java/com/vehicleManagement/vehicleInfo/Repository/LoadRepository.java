package com.vehicleManagement.vehicleInfo.Repository;

import com.vehicleManagement.vehicleInfo.Entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends JpaRepository<Load, Integer> {
}
