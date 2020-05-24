package com.example.demo.services;

import com.example.demo.models.AvailabilityEntity;
import com.example.demo.models.Cab;
import com.example.demo.models.TripType;
import com.example.demo.models.User;
import com.example.demo.response.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import requests.BookingRequest;

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


    public BookingResponse bookCab(TripType tripType , User user){
        AvailabilityEntity availabilityEntity = occupancyService.getSeat(user);
        if(availabilityEntity!=null){
            Cab cab = availabilityEntity.getCab();
            boolean isLastPassenger = cab.isFull();
            List<String> travellers = cab.getTravellersList();
            travellers.remove(user.getName());
            boolean waitingForMorePassengers=true;

            if(cab.isFull()){
                waitingForMorePassengers = false;
            }
            return  new BookingResponse("Success",isLastPassenger,travellers,cab.getRegistrationNumber(),waitingForMorePassengers,user);
        }

        return new BookingResponse("Failure: Booking failed ,No cabs are available",null,null,null, true,user);
    }



}
