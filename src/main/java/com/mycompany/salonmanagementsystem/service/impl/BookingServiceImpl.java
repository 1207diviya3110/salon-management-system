package com.mycompany.salonmanagementsystem.service.impl;

import com.mycompany.salonmanagementsystem.converter.BookingConverter;
import com.mycompany.salonmanagementsystem.dto.BookingDTO;
import com.mycompany.salonmanagementsystem.entity.BookingEntity;
import com.mycompany.salonmanagementsystem.exception.BusinessException;
import com.mycompany.salonmanagementsystem.exception.ErrorModel;
import com.mycompany.salonmanagementsystem.repository.BookingRepository;
import com.mycompany.salonmanagementsystem.repository.ServiceRepository;
import com.mycompany.salonmanagementsystem.repository.StoreRepository;
import com.mycompany.salonmanagementsystem.repository.UserRepository;
import com.mycompany.salonmanagementsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingConverter bookingConverter;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public BookingDTO bookAppointment(BookingDTO bookingDTO, Long userId, Long storeId, Long serviceId) {

        Optional<BookingEntity> optBe = bookingRepository.findByStoreIdAndServiceIdAndAppointmentDate(storeId,
                serviceId, bookingDTO.getBookingDate());
        if(optBe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("SLOT_ALREADY_BOOKED");
            errorModel.setMessage("Slot you are trying to book is already filled, try with another slot");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        } else {
            BookingEntity bookingEntity = new BookingEntity();
            bookingEntity.setBookingDate(bookingDTO.getBookingDate());
            bookingEntity.setUserEntity(userRepository.findById(userId).orElseThrow());
            bookingEntity.setStoreEntity(storeRepository.findById(storeId).orElseThrow());
            bookingEntity.setServiceEntity(serviceRepository.findById(serviceId).orElseThrow());

            bookingEntity = bookingRepository.save(bookingEntity);

            bookingDTO = bookingConverter.BookingEntityToDTO(bookingEntity);
        }
        return bookingDTO;
    }
}
