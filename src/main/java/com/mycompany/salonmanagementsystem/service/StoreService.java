package com.mycompany.salonmanagementsystem.service;

import com.mycompany.salonmanagementsystem.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    StoreDTO login(String email, String password);
    StoreDTO register(StoreDTO storeDTO);
    List<StoreDTO> getAllStoresByPincode(String pincode);
}
