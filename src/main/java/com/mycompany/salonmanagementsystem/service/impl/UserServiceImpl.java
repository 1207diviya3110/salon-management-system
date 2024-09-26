package com.mycompany.salonmanagementsystem.service.impl;

import com.mycompany.salonmanagementsystem.converter.UserConverter;
import com.mycompany.salonmanagementsystem.dto.UserDTO;
import com.mycompany.salonmanagementsystem.entity.UserEntity;
import com.mycompany.salonmanagementsystem.exception.BusinessException;
import com.mycompany.salonmanagementsystem.exception.ErrorModel;
import com.mycompany.salonmanagementsystem.repository.UserRepository;
import com.mycompany.salonmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO register(UserDTO userDTO) {

        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        Optional<UserEntity> optUe = userRepository.findByEmail(userEntity.getEmail());
        if (optUe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("The Email already exist!, try again with different one");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {

        UserDTO userDTO = null;
        Optional<UserEntity> optUe = userRepository.findByEmailAndPassword(email, password);
        if (optUe.isPresent()){
            userDTO = userConverter.convertEntityToDTO(optUe.get());
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return userDTO;
    }
}
