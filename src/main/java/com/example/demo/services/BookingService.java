package com.example.demo.services;

import com.example.demo.models.AvailabilityEntity;
import com.example.demo.models.Cab;
import com.example.demo.models.Passenger;
import com.example.demo.response.BookingResponse;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingService {
    private AvailabilityService availabilityService;
     private OccupancyService occupancyService;

    @Autowired
     BookingService(AvailabilityService availabilityService , OccupancyService occupancyService){
         this.availabilityService = availabilityService;
         this.occupancyService = occupancyService;
     }


    public BookingResponse bookCab(Passenger passenger){
        AvailabilityEntity availabilityEntity = occupancyService.getSeat(passenger);

        if(availabilityEntity!=null){
            Cab cab = availabilityEntity.getCab();
            boolean isLastPassenger = cab.isFull();
            List<String> fellow_travellers = cab.getTravellersList();

            return  new BookingResponse("Success",isLastPassenger,fellow_travellers);
        }

        return new BookingResponse("Failure",null,null);
    }



}
