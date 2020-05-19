package com.example.demo.controller;

import com.example.demo.models.Cab;
import com.example.demo.models.Passenger;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookingController{
    private  BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService= bookingService;
    }


    @RequestMapping(value = "/cab/book", method = RequestMethod.POST)
   public boolean bookCab(Passenger passenger){
        Boolean status = bookingService.bookCab(passenger);
        return status;
    }


    public boolean cancelBookedCab(Passenger passenger , Cab cab){
       return true;
    }


}
