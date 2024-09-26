package com.mycompany.salonmanagementsystem.service;

import com.mycompany.salonmanagementsystem.dto.BookingDTO;

public interface BookingService {

    BookingDTO bookAppointment(BookingDTO bookingDTO, Long userId, Long storeId, Long serviceId);
}
