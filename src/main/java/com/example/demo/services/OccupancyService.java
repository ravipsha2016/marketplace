package com.example.demo.services;

import com.example.demo.models.AvailabilityEntity;
import com.example.demo.models.Cab;
import com.example.demo.models.User;
import com.example.demo.models.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class OccupancyService {
    private AvailabilityService availabilityService;
    private SafetyRuleService safetyRuleService;

    @Autowired
    OccupancyService(AvailabilityService availabilityService, SafetyRuleService safetyRuleService){
        this.availabilityService = availabilityService;
        this.safetyRuleService = safetyRuleService;
    }

    static List<Cab> partiallyOccupiedCabs = new CopyOnWriteArrayList<>();
    int maxBuffer = 4;


    public AvailabilityEntity getSeat(User user) {

        boolean isAllocatedFromPartiallyOccupied = false;
        AvailabilityEntity availabilityEntity =null;

        /**
         *
         * Check partial occupied cabs if any.
         * Try to occupy, if success return
         * otherwise book from the available pool and add that cab in partially occupied pool
         * if the cab becomes full after borading the last passenger , start moving it and remove from partial occupied pool
         */

         availabilityEntity =  bookFromPartiallyOccupiedPool(user);

        if(availabilityEntity==null)
        {
            Cab cab = availabilityService.getAvailableCab();
            if (cab != null && partiallyOccupiedCabs.size() < maxBuffer) {
                partiallyOccupiedCabs.add(cab);
                Seat seat= assignSeat(user, cab);
                if(seat !=null){
                    availabilityEntity = new AvailabilityEntity(cab,seat);
                }

            }
        }

        return availabilityEntity;

    }

    AvailabilityEntity bookFromPartiallyOccupiedPool(User user){
        for(Cab cab : partiallyOccupiedCabs){
            Boolean isSafe = safetyRuleService.isSafe(user, cab);
            if(cab.isFull()){
                continue;
            }

            if(isSafe){
                Seat seat=assignSeat(user,cab);
                if(seat !=null){
                    if(cab.isFull()){
                        partiallyOccupiedCabs.remove(cab);
                        availabilityService.removeAvailability(cab);
                    }
                    return new AvailabilityEntity(cab,seat);
                }
            }

        }

        return null;
    }

     synchronized Seat assignSeat(User user, Cab cab){
        Seat seat = null;
        if (!cab.isFull()) {
            seat = cab.getAvailableSeat();
            seat.isEmpty = false;
            seat.user = user;
            int current_occupancy = cab.getCurrent_occupancy();
            cab.setCurrent_occupancy(++current_occupancy);
        }
        return seat;
    }

}

