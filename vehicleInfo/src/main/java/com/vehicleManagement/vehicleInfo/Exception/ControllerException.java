package com.vehicleManagement.vehicleInfo.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ControllerException  extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMsg;

    public ControllerException(String errorCode,String errorMsg){
        super();
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }
}
