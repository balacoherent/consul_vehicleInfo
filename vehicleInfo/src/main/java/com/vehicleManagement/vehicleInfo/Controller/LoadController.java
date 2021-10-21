package com.vehicleManagement.vehicleInfo.Controller;


import com.vehicleManagement.vehicleInfo.BaseResponse.BaseResponse;
import com.vehicleManagement.vehicleInfo.DTO.LoadDTO;
import com.vehicleManagement.vehicleInfo.Entity.Load;
import com.vehicleManagement.vehicleInfo.ServiceInterface.LoadInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RequestMapping("/loads")
@RestController
public class LoadController {

    @Autowired
    private LoadInterface loadInterface;

    @RolesAllowed(value="USER")
    @PostMapping("/create")
    public BaseResponse<Object> adddetail(@RequestBody LoadDTO loadDTO){
        BaseResponse base;
        base= BaseResponse.builder().Data(loadInterface.addload(loadDTO)).build();
        return base;
    }

    @RolesAllowed(value="USER")
    @GetMapping("/getAllLoad")
    public BaseResponse<List<Load>>listAll(){
        BaseResponse<List<Load>> base;
        base = BaseResponse.<List<Load>> builder().Data(loadInterface.ListAll1()).build();
        return base;
    }

    @RolesAllowed(value="USER")
    @PutMapping("/update")
    public BaseResponse<Optional<Load>> updatedetail(@RequestBody LoadDTO loadDTO){
        BaseResponse<Optional<Load>> base ;
        base = BaseResponse.<Optional<Load>>builder().Data(loadInterface.UpdateLoad(loadDTO)).build();
        return base;
    }

    @RolesAllowed(value="ADMIN")
    @DeleteMapping("/delete/{id}")
    public BaseResponse<Load> deleteLoad(@PathVariable int id){
        BaseResponse<Load>base ;
        base = BaseResponse.<Load>builder().Data(loadInterface.DeleteLoad(id)).build();
        return base;
    }

}

