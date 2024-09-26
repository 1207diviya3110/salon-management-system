package com.mycompany.salonmanagementsystem.repository;

import com.mycompany.salonmanagementsystem.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findById(Long id);
}
