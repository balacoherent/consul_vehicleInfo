package com.vehicleManagement.vehicleInfo.ServiceInterface;

import com.vehicleManagement.vehicleInfo.BaseResponse.PageResponse;
import com.vehicleManagement.vehicleInfo.DTO.UserDTO;
import com.vehicleManagement.vehicleInfo.DTO.UserRoleDTO;
import com.vehicleManagement.vehicleInfo.Entity.Load;
import com.vehicleManagement.vehicleInfo.Entity.User;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface UserInterface {

    User adduser(UserDTO userDTO);

   // List<User> ListAll();

    Optional<User> getuserById(int id);

    Optional<User> UpdateUser(UserDTO userDTO);

    UserRoleDTO generateToken(UserRoleDTO userRoleDTO);

    PageResponse<User> pageUser(int offset, int pageSize, String name);

    User deletebyid(int id);

    List<User> listAll();
}
