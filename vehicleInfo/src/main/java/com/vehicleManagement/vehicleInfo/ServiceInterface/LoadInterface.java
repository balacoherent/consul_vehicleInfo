package com.vehicleManagement.vehicleInfo.ServiceInterface;

import com.vehicleManagement.vehicleInfo.DTO.LoadDTO;
import com.vehicleManagement.vehicleInfo.Entity.Load;

import java.util.List;
import java.util.Optional;

public interface LoadInterface {

    Load addload(LoadDTO loadDTO);

    Optional<Load> UpdateLoad(LoadDTO loadDTO);

    Load DeleteLoad(int id);

    List<Load> ListAll1();
}
