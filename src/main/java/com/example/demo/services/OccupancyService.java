package com.example.demo.services;

import com.example.demo.models.AvailabilityEntity;
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


    public AvailabilityEntity getSeat(Passenger passenger) {

        boolean isAllocatedFromPartiallyOccupied = false;
        AvailabilityEntity availabilityEntity =null;

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

