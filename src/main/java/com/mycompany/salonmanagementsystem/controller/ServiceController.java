package com.mycompany.salonmanagementsystem.controller;

import com.mycompany.salonmanagementsystem.dto.ServiceDTO;
import com.mycompany.salonmanagementsystem.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/salon/v1/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/services/add/{storeId}")
    public ResponseEntity<ServiceDTO> addService (@RequestBody ServiceDTO serviceDTO, @PathVariable Long storeId){
        serviceDTO = serviceService.addService(serviceDTO, storeId);
        ResponseEntity<ServiceDTO> responseEntity = new ResponseEntity<>(serviceDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("/services/update/{serviceId}")
    public ResponseEntity<ServiceDTO> updateService (@RequestBody ServiceDTO serviceDTO, @PathVariable Long serviceId){
        serviceDTO = serviceService.updateService(serviceDTO, serviceId);
        ResponseEntity<ServiceDTO> responseEntity = new ResponseEntity<>(serviceDTO,HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/services/delete/{serviceId}")
    public ResponseEntity deleteService (@PathVariable Long serviceId){
        serviceService.deleteService(serviceId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }

    @GetMapping("/services/{storeId}")
    public ResponseEntity<List<ServiceDTO>> getAllServicesForStore(@PathVariable Long storeId){
        List<ServiceDTO> serviceList =  serviceService.getAllServiceForStore(storeId);
        ResponseEntity<List<ServiceDTO>> responseEntity = new ResponseEntity<>(serviceList, HttpStatus.OK);
        return responseEntity;
    }
}
