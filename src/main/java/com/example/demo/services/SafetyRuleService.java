package com.example.demo.services;

import com.example.demo.models.Cab;
import com.example.demo.models.User;
import com.example.demo.models.Seat;
import org.springframework.stereotype.Component;

@Component
public class SafetyRuleService {


    // mmm f    x
    // fff m    x
    // mmm m    x
    // fff f    y
    //mmf  m    x
    //ffm  f    y

   Boolean isSafe(User user, Cab cab){
       if(cab.getCurrent_occupancy() +1 == cab.getCapacity()){
           int gender_score= user.getGender().getValue();
           for(Seat seat : cab.getSeatMatrix()){
               if(!seat.isEmpty) {
                   int gender_value = seat.getUser().getGender().getValue();
                   gender_score += gender_value;
               }
           }

           if(gender_score==0 || gender_score==2|| gender_score==4){
               return true;
           }
           else
               return false;
       }
       return true;
    }
}
