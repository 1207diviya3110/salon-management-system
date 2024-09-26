package com.mycompany.salonmanagementsystem.service.impl;

import com.mycompany.salonmanagementsystem.converter.StoreConverter;
import com.mycompany.salonmanagementsystem.dto.StoreDTO;
import com.mycompany.salonmanagementsystem.entity.StoreEntity;
import com.mycompany.salonmanagementsystem.entity.UserEntity;
import com.mycompany.salonmanagementsystem.exception.BusinessException;
import com.mycompany.salonmanagementsystem.exception.ErrorModel;
import com.mycompany.salonmanagementsystem.repository.StoreRepository;
import com.mycompany.salonmanagementsystem.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreConverter storeConverter;

    @Override
    public StoreDTO login(String email, String password) {
        StoreDTO storeDTO = null;
        Optional<StoreEntity> optSe = storeRepository.findByEmailAndPassword(email, password);
        if (optSe.isPresent()){
            storeDTO = storeConverter.convertStoreEntityToDTO(optSe.get());
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return storeDTO;
    }

    @Override
    public StoreDTO register(StoreDTO storeDTO) {
        StoreEntity storeEntity = storeConverter.convertStoreDTOtoEntity(storeDTO);
        Optional<StoreEntity> ose = storeRepository.findByEmail(storeEntity.getEmail());
        if (ose.isPresent()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXISTS");
            errorModel.setMessage("The email you are using already exists, try again with another one");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);

        }
        storeEntity = storeRepository.save(storeEntity);
        storeDTO = storeConverter.convertStoreEntityToDTO(storeEntity);
        return storeDTO;
    }

    @Override
    public List<StoreDTO> getAllStoresByPincode(String pincode) {
        List<StoreEntity> listOfStores = storeRepository.findALlByPincode(pincode);
        List<StoreDTO> storeDTOList = new ArrayList<>();
        for(StoreEntity se: listOfStores){
            StoreDTO storeDTO = storeConverter.convertStoreEntityToDTO(se);
            storeDTOList.add(storeDTO);
        }

        return storeDTOList;
    }
}
