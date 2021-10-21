package com.vehicleManagement.vehicleInfo.BaseResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PageResponse <T>{

    Integer recordCount;
    T response;
}

