package com.example.demo.services;

import com.example.demo.models.Cab;
import com.example.demo.response.AvailabilityRegisteredResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class AvailabilityService {
    private CabRegisterService registerService;

    @Autowired
    public AvailabilityService(CabRegisterService registerService){
        this.registerService = registerService;
    }
    static LinkedList<Cab> availableCabsPool = new LinkedList<Cab>();

    boolean isAvailable(){
        return availableCabsPool.size()!=0;
    }

    Cab getAvailableCab(){
        Cab cab = null;
        if (isAvailable()){
            cab = availableCabsPool.getFirst();
            //availableCabsPool.removeFirst();
        }
        return cab;
    }

    public LinkedList<Cab> getavailableCabsPool(){
        return this.availableCabsPool;
    }


    public AvailabilityRegisteredResponse registerAvailability(Cab cab){

        if(registerService.getMembership(cab)){
            getavailableCabsPool().add(cab);
            return new AvailabilityRegisteredResponse(cab , "Availability registered Successfully " );
        }
        else
            return new AvailabilityRegisteredResponse(cab , "Failure: Cab is not registered with aggregator" );

    }

    public void removeAvailability(Cab cab){
        if(registerService.getMembership(cab)) {
            getavailableCabsPool().remove(cab);
        }
    }







}
