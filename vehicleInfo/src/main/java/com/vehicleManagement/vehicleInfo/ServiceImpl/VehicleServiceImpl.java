package com.vehicleManagement.vehicleInfo.ServiceImpl;

import com.vehicleManagement.vehicleInfo.BaseResponse.PageResponse;
import com.vehicleManagement.vehicleInfo.DTO.VehicleDTO;
import com.vehicleManagement.vehicleInfo.Entity.User;
import com.vehicleManagement.vehicleInfo.Entity.Vehicle;
import com.vehicleManagement.vehicleInfo.Entity.VehicleType;
import com.vehicleManagement.vehicleInfo.Exception.ControllerException;
import com.vehicleManagement.vehicleInfo.Repository.UserRepository;
import com.vehicleManagement.vehicleInfo.Repository.VehicleRepository;
import com.vehicleManagement.vehicleInfo.Repository.VehicleTypeRepository;
import com.vehicleManagement.vehicleInfo.ServiceInterface.VehicleInterfce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleInterfce {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRespository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public Vehicle addvehicle(VehicleDTO vehicleDTO) {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName(vehicleDTO.getVehicleName());
        vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        Optional<VehicleType> vehicleType=vehicleTypeRepository
                .findById(vehicleDTO.getVehicle_type_id());
        vehicleType.ifPresent(vehicle::setVehicle_type_id);
        Vehicle finalVehicle = vehicle;
        vehicleDTO.getUserId().forEach(userDTO -> {
            Optional<User> user = userRepository.findById(userDTO.getId());
            user.ifPresent(finalVehicle::setUser);
        });

        Vehicle obj=vehicleRespository.save(vehicle);
        return vehicle;
    }

    @Override
    public Optional<Vehicle> updatevehicle(VehicleDTO vehicleDTO) {

        Optional<Vehicle> existVehicle = vehicleRespository.findById(vehicleDTO.getVehicle_id());
        if (existVehicle.isPresent()){

            existVehicle.get().setVehicleName(vehicleDTO.getVehicleName());
            existVehicle.get().setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        }
        else {
            throw new ControllerException("404","There is no vehicle here!! "  );
        }


        Optional<VehicleType> vehicleType=vehicleTypeRepository.findById(vehicleDTO
                .getVehicle_type_id());
        if (vehicleType.isPresent()){

            existVehicle.get().setVehicle_type_id(vehicleType.get());
        }
        else {
            throw new ControllerException("404","Vehicle is not found");
        }
        vehicleDTO.getUserId().forEach(userDTO -> {
            Optional<User> user = userRepository.findById(userDTO.getId());
            if (user.isPresent()){

                existVehicle.get().setUser(user.get());
            }
            else {
                throw new ControllerException("404","vehicle is not found");
            }
        });
        Vehicle obj= vehicleRespository.save(existVehicle.get());
        return existVehicle;
    }

    @Override
    public PageResponse<Vehicle> vehiclePagination(int offset, int pageSize, String vehicleName) {

        Pageable paging= PageRequest.of(offset,pageSize);
        Page<Vehicle> vehicles=vehicleRespository.searchAllByvehicleNameLike("%"+ vehicleName +"%", paging);
        PageResponse pageResponse = new PageResponse();
        pageResponse.setResponse(vehicles);
        pageResponse.setRecordCount(vehicles.getTotalPages());
        return pageResponse;



    }

    @Override
    public Optional<Vehicle> findvehicleById(int id) {

        Optional<Vehicle> vehicle=vehicleRespository.findById(id);
        return vehicle;
    }

    @Override
    public Vehicle deletevehicle(int id) {


        Vehicle vehicle = new Vehicle();
        vehicleRespository.deleteById(id);
        return vehicle;
    }
}
