package com.example.demo.services;

import com.example.demo.models.AvailabilityEntity;
import com.example.demo.models.Cab;
import com.example.demo.models.Passenger;
import com.example.demo.response.BookingResponse;
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
            List<String> travellers = cab.getTravellersList();
            travellers.remove(passenger.getName());
            boolean waitingForMorePassengers=true;

            if(cab.isFull()){
                waitingForMorePassengers = false;
            }
            return  new BookingResponse("Success",isLastPassenger,travellers,cab.registrationNumber,waitingForMorePassengers);
        }

        return new BookingResponse("Failure: Booking failed ,No cabs are available",null,null,null, true);
    }



}
