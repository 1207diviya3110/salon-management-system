package com.mycompany.salonmanagementsystem.converter;

import com.mycompany.salonmanagementsystem.dto.StoreDTO;
import com.mycompany.salonmanagementsystem.entity.StoreEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreConverter {
    public StoreEntity convertStoreDTOtoEntity(StoreDTO storeDTO){
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setId(storeDTO.getId());
        storeEntity.setName(storeDTO.getName());
        storeEntity.setEmail(storeDTO.getEmail());
        storeEntity.setPhone(storeDTO.getPhone());
        storeEntity.setPassword(storeDTO.getPassword());
        storeEntity.setStreet(storeDTO.getStreet());
        storeEntity.setCity(storeDTO.getCity());
        storeEntity.setCountry(storeDTO.getCountry());
        storeEntity.setPincode(storeDTO.getPincode());
        return storeEntity;
    }

    public StoreDTO convertStoreEntityToDTO(StoreEntity storeEntity){
        StoreDTO storeDTO = new StoreDTO();

        storeDTO.setId(storeEntity.getId());
        storeDTO.setName(storeEntity.getName());
        storeDTO.setEmail(storeEntity.getEmail());
        storeDTO.setPhone(storeEntity.getPhone());
        storeDTO.setStreet(storeEntity.getStreet());
        storeDTO.setCity(storeEntity.getCity());
        storeDTO.setCountry(storeEntity.getCountry());
        storeDTO.setPincode(storeEntity.getPincode());

        return storeDTO;
    }
}
