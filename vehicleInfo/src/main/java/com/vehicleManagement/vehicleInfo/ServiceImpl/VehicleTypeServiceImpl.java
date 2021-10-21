package com.vehicleManagement.vehicleInfo.ServiceImpl;

import com.vehicleManagement.vehicleInfo.DTO.LoadDTO;
import com.vehicleManagement.vehicleInfo.DTO.VehicleTypeDTO;
import com.vehicleManagement.vehicleInfo.Entity.Load;
import com.vehicleManagement.vehicleInfo.Entity.Vehicle;
import com.vehicleManagement.vehicleInfo.Entity.VehicleType;
import com.vehicleManagement.vehicleInfo.Exception.ControllerException;
import com.vehicleManagement.vehicleInfo.Repository.LoadRepository;
import com.vehicleManagement.vehicleInfo.Repository.VehicleRepository;
import com.vehicleManagement.vehicleInfo.Repository.VehicleTypeRepository;
import com.vehicleManagement.vehicleInfo.ServiceInterface.VehicleTypeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class VehicleTypeServiceImpl implements VehicleTypeInterface {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public VehicleType addvehicleType(VehicleTypeDTO vehicleTypeDTO) {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setVehicleTypeName(vehicleTypeDTO.getVehicleTypeName());
        VehicleType obj = vehicleTypeRepository.save(vehicleType);
        return vehicleType;
    }

    @Override
    public Optional<VehicleType> updatevehicleType(VehicleTypeDTO vehicleTypeDTO) {

        Optional<VehicleType> existVehicleType = vehicleTypeRepository.findById(vehicleTypeDTO.getVehicle_type_id());
        if (existVehicleType.isPresent()){

            existVehicleType.get().setVehicle_type_id(vehicleTypeDTO.getVehicle_type_id());
            existVehicleType.get().setVehicleTypeName(vehicleTypeDTO.getVehicleTypeName());
        }
        else {
            throw new ControllerException("404","No details found");
        }

        VehicleType obj = vehicleTypeRepository.save(existVehicleType.get());
        return existVehicleType;
    }

    @Override
    public VehicleType deletevehicleType(int id) {

        VehicleType vehicleType = new VehicleType();
        vehicleTypeRepository.deleteById(id);
        return vehicleType;
    }

    @Override
    public List<VehicleType> listAll() {
        List<VehicleType> obj=vehicleTypeRepository.findAll();
        return obj;
    }

}


