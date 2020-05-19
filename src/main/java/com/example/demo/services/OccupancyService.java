package com.example.demo.services;

import com.example.demo.models.AvailabilityEntity;
import com.example.demo.models.Cab;
import com.example.demo.models.Passenger;
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


    public AvailabilityEntity getSeat(Passenger passenger) {

        boolean isAllocatedFromPartiallyOccupied = false;
        AvailabilityEntity availabilityEntity =null;

        /**
         *
         * Check partial occupied cabs if any.
         * Try to occupy, if success return
         * otherwise book from the available pool and add that cab in partially occupied pool
         * if the cab becomes full after borading the last passenger , start moving it and remove from partial occupied pool
         */

         availabilityEntity =  bookFromPartiallyOccupiedPool(passenger);

        if(availabilityEntity==null)
        {
            Cab cab = availabilityService.getAvailableCab();
            if (cab != null && partiallyOccupiedCabs.size() < maxBuffer) {
                partiallyOccupiedCabs.add(cab);
                Seat seat= assignSeat(passenger , cab);
                if(seat !=null){
                    availabilityEntity = new AvailabilityEntity(cab,seat);
                }

            }
        }

        return availabilityEntity;

    }

    AvailabilityEntity bookFromPartiallyOccupiedPool(Passenger passenger){
        for(Cab cab : partiallyOccupiedCabs){
            List<Seat> seats =  cab.seatMatrix;
            Boolean isSafe = safetyRuleService.isSafe(passenger, seats);
            if(cab.isFull()){
                continue;
            }

            if(isSafe){
                Seat seat=assignSeat(passenger ,cab);
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

    Seat assignSeat(Passenger passenger, Cab cab ){
        Seat seat = null;
        if (!cab.isFull()) {
            seat = cab.getAvailableSeat();
            seat.isEmpty = false;
            seat.passenger = passenger;
            cab.current_occupancy++;
        }
        return seat;
    }

}

