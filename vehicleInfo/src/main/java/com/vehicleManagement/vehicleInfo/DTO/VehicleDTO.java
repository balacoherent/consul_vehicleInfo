package com.vehicleManagement.vehicleInfo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class VehicleDTO {

    private  Integer vehicle_id;

    private String vehicleName;

    private Integer registrationNumber;

    private Integer vehicle_type_id;

    private List<UserDTO> userId;
}
