package com.example.demo.services;

import com.example.demo.models.Cab;
import com.example.demo.models.Passenger;
import com.example.demo.models.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OccupancyService {
    private AvailabilityService availabilityService;
    private SafetyRuleService safetyRuleService;

    @Autowired
    OccupancyService(AvailabilityService availabilityService, SafetyRuleService safetyRuleService){
        this.availabilityService = availabilityService;
        this.safetyRuleService = safetyRuleService;
    }

    static List<Cab> partiallyOccupiedCabs = new ArrayList<Cab>();
    int maxBuffer = 4;


    public boolean getSeat(Passenger passenger) {

        boolean isAllocatedFromPartiallyOccupied = false;

        for(Cab cab : partiallyOccupiedCabs){
            List<Seat> seats =  cab.seatMatrix;
            Boolean isSafe = safetyRuleService.isSafe(passenger, seats);

            if(isSafe){
                assignSeat(passenger ,cab);
                isAllocatedFromPartiallyOccupied = true;
            }

        }

        if(!isAllocatedFromPartiallyOccupied)
        {
            Cab availableCab = availabilityService.getAvailableCab();
            if (availableCab != null && partiallyOccupiedCabs.size() < maxBuffer) {
                partiallyOccupiedCabs.add(availableCab);
                assignSeat(passenger , availableCab);

            }
        }

        return true;

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

