package com.mycompany.salonmanagementsystem.controller;

import com.mycompany.salonmanagementsystem.dto.StoreDTO;
import com.mycompany.salonmanagementsystem.dto.UserDTO;
import com.mycompany.salonmanagementsystem.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/salon/v1/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/register")
    public ResponseEntity<StoreDTO> register(@RequestBody StoreDTO storeDTO){
        storeDTO = storeService.register(storeDTO);
        ResponseEntity<StoreDTO> responseEntity = new ResponseEntity<>(storeDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<StoreDTO> login(@RequestBody StoreDTO storeDTO){
        storeDTO = storeService.login(storeDTO.getEmail(), storeDTO.getPassword());
        ResponseEntity<StoreDTO> responseEntity = new ResponseEntity<>(storeDTO, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/stores/{pincode}")
    public ResponseEntity<List<StoreDTO>> getStores(@PathVariable String pincode){
        List<StoreDTO> propertyList =  storeService.getAllStoresByPincode(pincode);
        ResponseEntity<List<StoreDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }


}
