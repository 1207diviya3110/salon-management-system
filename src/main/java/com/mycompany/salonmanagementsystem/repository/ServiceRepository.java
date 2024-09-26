package com.mycompany.salonmanagementsystem.repository;

import com.mycompany.salonmanagementsystem.entity.ServiceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {

    @Query("SELECT s FROM ServiceEntity s WHERE s.storeEntity.id = :storeId")
    List<ServiceEntity> findByALlByStoreEntityId(@Param("storeId") Long storeId);

    Optional<ServiceEntity> findById(Long id);
}
