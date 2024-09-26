package com.mycompany.salonmanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingDTO {

    private Long id;
    private String bookingDate;
    private Long userid;
    private Long serviceId;
    private Long storeId;
}
