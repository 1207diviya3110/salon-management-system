package com.mycompany.salonmanagementsystem.service;

import com.mycompany.salonmanagementsystem.dto.ServiceDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ServiceService {
    ServiceDTO addService(ServiceDTO serviceDTO, Long storeId);
    ServiceDTO updateService(ServiceDTO serviceDTO, Long id);
    void deleteService(Long id);
    List<ServiceDTO> getAllServiceForStore(Long id);
}
