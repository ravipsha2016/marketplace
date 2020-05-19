package com.example.demo.services;

import com.example.demo.models.Cab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class AvailabilityService {
    private CabRegisterService registerService;

    @Autowired
    AvailabilityService(CabRegisterService registerService){
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







}
