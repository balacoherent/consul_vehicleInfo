package com.vehicleManagement.vehicleInfo.Controller;

import com.vehicleManagement.vehicleInfo.BaseResponse.BaseResponse;
import com.vehicleManagement.vehicleInfo.DTO.VehicleTypeDTO;
import com.vehicleManagement.vehicleInfo.Entity.VehicleType;
import com.vehicleManagement.vehicleInfo.ServiceInterface.VehicleTypeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/vehicleType")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeInterface vehicleTypeInterface;

    @RolesAllowed(value="USER")
    @PostMapping("/create")
    public BaseResponse addvehicle(@RequestBody VehicleTypeDTO vehicleTypeDTO){
        BaseResponse base;
        base= BaseResponse.builder().Data(vehicleTypeInterface.addvehicleType(vehicleTypeDTO)).build();
        return base;
    }

    @RolesAllowed(value="USER")
    @GetMapping("/getAllType")
    public BaseResponse<List<VehicleType>>listAll(){
        BaseResponse<List<VehicleType>> base;
        base = BaseResponse.<List<VehicleType>> builder().Data(vehicleTypeInterface.listAll()).build();
        return base;
    }

    @RolesAllowed(value="USER")
    @PutMapping("/update")
    public BaseResponse updatedetail(@RequestBody VehicleTypeDTO vehicleTypeDTO){
        BaseResponse base ;
        base = BaseResponse.builder().Data(vehicleTypeInterface.updatevehicleType(vehicleTypeDTO)).build();
        return base;
    }

    @RolesAllowed(value="ADMIN")
    @DeleteMapping("/delete/{id}")
    public BaseResponse deletedetail(@PathVariable int id){
        BaseResponse base ;
        base = BaseResponse.builder().Data(vehicleTypeInterface.deletevehicleType(id)).build();
        return base;
    }



}

