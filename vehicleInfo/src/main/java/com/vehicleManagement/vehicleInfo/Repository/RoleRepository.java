package com.vehicleManagement.vehicleInfo.Repository;

import com.vehicleManagement.vehicleInfo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
