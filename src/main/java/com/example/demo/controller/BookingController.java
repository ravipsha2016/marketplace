package com.example.demo.controller;

import com.example.demo.exceptions.ValidationException;
import com.example.demo.models.Cab;
import com.example.demo.models.TripType;
import com.example.demo.models.User;
import com.example.demo.response.BookingResponse;
import com.example.demo.services.BookingService;
import com.example.demo.services.UserRegistrationService;
import com.example.demo.validators.BookingRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.BookingRequest;


@RestController
public class BookingController{
    private  BookingService bookingService;
    private UserRegistrationService userRegistrationService;
    private BookingRequestValidator bookingRequestValidator;

    @Autowired
    BookingController(BookingService bookingService,UserRegistrationService userRegistrationService,
    BookingRequestValidator bookingRequestValidator){
        this.bookingService= bookingService;
        this.userRegistrationService= userRegistrationService;
        this.bookingRequestValidator = bookingRequestValidator;
    }


    @PostMapping(value = "/book", consumes = "application/json")
    public ResponseEntity<BookingResponse> bookCab(@RequestBody BookingRequest bookingRequest) throws ValidationException {
       try {
           bookingRequestValidator.validate(bookingRequest);
           String user_id = bookingRequest.getUser_uuid();
           User user = userRegistrationService.retriveUser(user_id);
           TripType tripType = bookingRequest.getTripType();

           BookingResponse response = bookingService.bookCab(tripType, user);
           return new ResponseEntity<>(response, HttpStatus.OK);
       }
        catch (ValidationException e){
            BookingResponse response = new BookingResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    public boolean cancelBookedCab(User user, Cab cab){
       return true;
    }


}
