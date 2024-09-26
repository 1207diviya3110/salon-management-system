package com.mycompany.salonmanagementsystem.repository;

import com.mycompany.salonmanagementsystem.entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends CrudRepository<StoreEntity, Long> {

    List<StoreEntity> findALlByPincode(String pincode);
    Optional<StoreEntity> findByEmailAndPassword(String email, String password);
    Optional<StoreEntity> findByEmail(String email);
    Optional<StoreEntity> findById(Long id);
}
