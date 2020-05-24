package com.example.demo.services;

import com.example.demo.models.Cab;
import com.example.demo.response.RegisteredAvailabilityResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
            availableCabsPool.remove(cab);
        }
        return cab;
    }

    public LinkedList<Cab> getavailableCabsPool(){
        return this.availableCabsPool;
    }


    public RegisteredAvailabilityResponse registerAvailability(Cab cab){

        if(registerService.getMembership(cab)){
            getavailableCabsPool().add(cab);
            return new RegisteredAvailabilityResponse(cab , "Availability registered Successfully " );
        }
        else
            return new RegisteredAvailabilityResponse(cab , "Failure: Cab is not registered with aggregator" );

    }

    public void removeAvailability(Cab cab){
        if(registerService.getMembership(cab)) {
            getavailableCabsPool().remove(cab);
        }
    }







}
