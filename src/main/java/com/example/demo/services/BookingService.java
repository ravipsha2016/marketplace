package com.example.demo.services;

import com.example.demo.models.Cab;
import com.example.demo.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BookingService {
    private AvailabilityService availabilityService;
     private OccupancyService occupancyService;

    @Autowired
     BookingService(AvailabilityService availabilityService , OccupancyService occupancyService){
         this.availabilityService = availabilityService;
         this.occupancyService = occupancyService;
     }


    public boolean bookCab(Passenger passenger){
        Boolean request_status = occupancyService.getSeat(passenger);

        if(request_status){

        }

        return false;
    }



}
