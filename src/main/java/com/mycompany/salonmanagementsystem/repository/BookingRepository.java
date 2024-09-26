package com.mycompany.salonmanagementsystem.repository;

import com.mycompany.salonmanagementsystem.entity.BookingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface BookingRepository extends CrudRepository<BookingEntity, Long> {

    @Query("SELECT b FROM BookingEntity b WHERE b.storeEntity.id = :storeId AND b.serviceEntity.id = :serviceId AND b.bookingDate = :date")
    Optional<BookingEntity> findByStoreIdAndServiceIdAndAppointmentDate(@Param("storeId") Long storeId, @Param("serviceId") Long serviceId, @Param("date") String date);
}
