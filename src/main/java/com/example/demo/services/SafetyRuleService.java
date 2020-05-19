package com.example.demo.services;

import com.example.demo.models.Passenger;
import com.example.demo.models.Seat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SafetyRuleService {

   Boolean isSafe(Passenger passenger , List<Seat> matrix){

       return  true;

    }
}
