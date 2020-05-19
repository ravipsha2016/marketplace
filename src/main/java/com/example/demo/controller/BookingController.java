package com.example.demo.controller;

import com.example.demo.models.Cab;
import com.example.demo.models.Passenger;
import com.example.demo.response.AvailabilityRegisteredResponse;
import com.example.demo.response.BookingResponse;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookingController{
    private  BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService= bookingService;
    }


    @PostMapping(value = "/book", consumes = "application/json")
   public ResponseEntity<BookingResponse> bookCab(@RequestBody Passenger passenger){
        BookingResponse response =  bookingService.bookCab(passenger);
        return new ResponseEntity<BookingResponse>(response, HttpStatus.OK);
    }


    public boolean cancelBookedCab(Passenger passenger , Cab cab){
       return true;
    }


}
