package com.vehicleManagement.vehicleInfo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class LoadDTO {

    private Integer load_id;

    private String loadName;

    private String destination;

    private List<VehicleDTO> vehicleId;

}

