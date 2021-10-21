package com.vehicleManagement.vehicleInfo.Controller;

import com.vehicleManagement.vehicleInfo.BaseResponse.BaseResponse;
import com.vehicleManagement.vehicleInfo.BaseResponse.PageResponse;
import com.vehicleManagement.vehicleInfo.DTO.UserDTO;
import com.vehicleManagement.vehicleInfo.DTO.UserRoleDTO;
import com.vehicleManagement.vehicleInfo.Entity.Load;
import com.vehicleManagement.vehicleInfo.Entity.User;
import com.vehicleManagement.vehicleInfo.ServiceInterface.UserInterface;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/user")
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInterface userInterface;

    @PostMapping(value="/create")
    public BaseResponse<User> SaveUser(@RequestBody UserDTO userDTO){
        BaseResponse<User> baseResponse;
        baseResponse = BaseResponse.<User>builder().Data(userInterface.adduser(userDTO)).build();
        logger.info("This is sample info message");
        logger.error("This is sample error message");
        return baseResponse;
    }

    @GetMapping(value = "/login")
    @ApiOperation(value = "user login ")
    public BaseResponse<UserRoleDTO> tokenGenerate(@RequestBody UserRoleDTO userRoleDTO) {
        BaseResponse<UserRoleDTO> baseResponse;
        baseResponse = BaseResponse.<UserRoleDTO>builder().Data(userInterface.generateToken(userRoleDTO)).build();
        logger.info("This is sample info message");
        logger.error("This is sample error message");
        return baseResponse;
    }

    @RolesAllowed(value="USER")
    @GetMapping("/getAll")
    public BaseResponse<List<User>>listAll(){
        BaseResponse<List<User>> base;
        base = BaseResponse.<List<User>> builder().Data(userInterface.listAll()).build();
        return base;
    }

    @RolesAllowed(value="USER")
    @PutMapping("/update")
    public BaseResponse<Optional<User>> updateUser(@Valid @RequestBody UserDTO userDTO) {
        BaseResponse<Optional<User>> baseResponse;
        baseResponse=BaseResponse.<Optional<User>>builder().Data(userInterface.UpdateUser(userDTO)).build();
        return baseResponse ;
    }

    @RolesAllowed(value="USER")
    @GetMapping("/{id}")
    public BaseResponse<Optional<User>> FindById(@PathVariable int id)  {
        BaseResponse<Optional<User>> baseResponse;
        baseResponse =BaseResponse.<Optional<User>>builder().Data(userInterface.getuserById(id)).build();
        logger.info("This is sample info message");
        logger.error("This is sample error message");
        return baseResponse;
    }

    @RolesAllowed(value="USER")
    @GetMapping("/{offset}/{pageSize}/{name}")
    public PageResponse<User> getPagination
            (@PathVariable int offset, @PathVariable int pageSize, @PathVariable String name){
        logger.info("This is sample info message");
        logger.error("This is sample error message");
        return userInterface.pageUser(offset, pageSize, name);
    }

    @RolesAllowed(value="ADMIN")
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        userInterface.deletebyid(id);
        logger.info("This is sample info message");
        logger.error("This is sample error message");
        return "Success";
    }

}

