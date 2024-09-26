package com.mycompany.salonmanagementsystem.service;

import com.mycompany.salonmanagementsystem.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);

}
