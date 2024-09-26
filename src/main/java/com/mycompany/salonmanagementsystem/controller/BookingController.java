package com.mycompany.salonmanagementsystem.controller;

import com.mycompany.salonmanagementsystem.dto.BookingDTO;
import com.mycompany.salonmanagementsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salon/api/vi/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add/{userId}/{storeId}/{serviceId}")
    public ResponseEntity<BookingDTO> bookingAppointment(@RequestBody BookingDTO bookingDTO, @PathVariable Long userId, @PathVariable Long storeId, @PathVariable Long serviceId){

        bookingDTO = bookingService.bookAppointment(bookingDTO,userId, storeId, serviceId );
        ResponseEntity<BookingDTO> responseEntity = new ResponseEntity<>(bookingDTO, HttpStatus.CREATED);
        return responseEntity;
    }
}
