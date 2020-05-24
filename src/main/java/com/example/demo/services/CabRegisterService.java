package com.example.demo.services;

import com.example.demo.models.Cab;
import com.example.demo.response.CabRegistrationResponse;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CabRegisterService {
    private static HashMap<String ,Cab> fleet = new HashMap<>();

   public void registerCabWithAggregator(Cab cab){
       fleet.put(cab.getRegistrationNumber(), cab);
    }

    public void deRegisterCabWithAggregator(Cab cab){
       fleet.remove(cab.getRegistrationNumber());
    }

    public boolean getMembership(Cab cab){
       return fleet.containsKey(cab.getRegistrationNumber());

    }

    public List<CabRegistrationResponse> getAllRegisteredCabs(){
        List<CabRegistrationResponse> registered_cabs = new ArrayList<>();
       for(Map.Entry<String ,Cab>entry : fleet.entrySet()){
           CabRegistrationResponse cab = new CabRegistrationResponse();
           cab.setRegistrationNumber(entry.getValue().getRegistrationNumber());
           registered_cabs.add(cab);
       }
       return registered_cabs;
       }


}
