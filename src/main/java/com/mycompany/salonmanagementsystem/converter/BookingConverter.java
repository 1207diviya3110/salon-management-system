package com.mycompany.salonmanagementsystem.converter;

import com.mycompany.salonmanagementsystem.dto.BookingDTO;
import com.mycompany.salonmanagementsystem.entity.BookingEntity;
import org.springframework.stereotype.Component;

@Component
public class BookingConverter {


    public BookingEntity BookingDTOtoEntity(BookingDTO bookingDTO){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setBookingDate(bookingDTO.getBookingDate());
        return bookingEntity;
    }

    public BookingDTO BookingEntityToDTO(BookingEntity bookingEntity){
        BookingDTO dto = new BookingDTO();
        dto.setId(bookingEntity.getId());
        dto.setBookingDate(bookingEntity.getBookingDate());
        dto.setUserid(bookingEntity.getUserEntity().getUserId());
        dto.setServiceId(bookingEntity.getServiceEntity().getId());
        dto.setStoreId(bookingEntity.getStoreEntity().getId());

        return dto;
    }

}
