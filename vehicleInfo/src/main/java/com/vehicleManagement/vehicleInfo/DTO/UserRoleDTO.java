package com.vehicleManagement.vehicleInfo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRoleDTO {

    private Integer id;

    private String name;

    private String jwtToken;

    private String password;

}
