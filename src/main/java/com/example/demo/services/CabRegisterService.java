package com.example.demo.services;

import com.example.demo.models.Cab;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CabRegisterService {
    private static HashMap<String ,Cab> fleet = new HashMap<>();

   public void registerCabWithAggregator(Cab cab){
       fleet.put(cab.registrationNumber, cab);
    }

    public void deRegisterCabWithAggregator(Cab cab){
       fleet.remove(cab.registrationNumber);
    }

    public boolean getMembership(Cab cab){
       return fleet.containsKey(cab.registrationNumber);

    }

    public List<Cab> getAllRegisteredCabs(){
       return (List) fleet.values();
       }


}
