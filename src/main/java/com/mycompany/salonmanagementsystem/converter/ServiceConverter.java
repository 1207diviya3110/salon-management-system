package com.mycompany.salonmanagementsystem.converter;

import com.mycompany.salonmanagementsystem.dto.ServiceDTO;
import com.mycompany.salonmanagementsystem.entity.ServiceEntity;
import org.springframework.stereotype.Component;

@Component
public class ServiceConverter {

    public ServiceDTO convertServiceEntityTODTO(ServiceEntity serviceEntity){
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(serviceEntity.getId());
        serviceDTO.setName(serviceEntity.getName());
        serviceDTO.setPrice(serviceEntity.getPrice());
        serviceDTO.setStoreid(serviceEntity.getStoreEntity().getId());

        return serviceDTO;
    }

    public ServiceEntity convertServiceDTOtoEntity(ServiceDTO serviceDTO){

        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setId(serviceDTO.getId());
        serviceEntity.setName(serviceDTO.getName());
        serviceEntity.setPrice(serviceDTO.getPrice());


        return serviceEntity;
    }
}
