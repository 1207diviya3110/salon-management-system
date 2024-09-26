package com.mycompany.salonmanagementsystem.service.impl;

import com.mycompany.salonmanagementsystem.converter.ServiceConverter;
import com.mycompany.salonmanagementsystem.dto.ServiceDTO;
import com.mycompany.salonmanagementsystem.entity.ServiceEntity;
import com.mycompany.salonmanagementsystem.repository.ServiceRepository;
import com.mycompany.salonmanagementsystem.repository.StoreRepository;
import com.mycompany.salonmanagementsystem.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceConverter serviceConverter;

    @Autowired
    private StoreRepository storeRepository;


    @Override
    public ServiceDTO addService(ServiceDTO serviceDTO, Long storeId) {

        ServiceEntity serviceEntity = serviceConverter.convertServiceDTOtoEntity(serviceDTO);
        serviceEntity.setStoreEntity(storeRepository.findById(storeId).orElseThrow());
        serviceEntity = serviceRepository.save(serviceEntity);
        serviceDTO = serviceConverter.convertServiceEntityTODTO(serviceEntity);

        return serviceDTO;
    }

    @Override
    public ServiceDTO updateService(ServiceDTO serviceDTO, Long id) {
        Optional<ServiceEntity> optEn =  serviceRepository.findById(id);
        ServiceDTO dto = null;
        if(optEn.isPresent()){

            ServiceEntity se = optEn.get();
            se.setName(serviceDTO.getName());
            se.setPrice(serviceDTO.getPrice());
            dto = serviceConverter.convertServiceEntityTODTO(se);
            serviceRepository.save(se); //saving the updated entity
        }
        return dto;

    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);

    }

    @Override
    public List<ServiceDTO> getAllServiceForStore(Long id) {

        List<ServiceEntity> listOfServices = (List<ServiceEntity>) serviceRepository.findByALlByStoreEntityId(id);
        List<ServiceDTO> servicesList = new ArrayList<>();

        for(ServiceEntity se: listOfServices){
            ServiceDTO serviceDTO = serviceConverter.convertServiceEntityTODTO(se);
            servicesList.add(serviceDTO);
        }
        return servicesList;
    }
}
