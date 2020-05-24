package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.response.BookingResponse;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserRegistrationService {
    static HashMap<String,User> registeredUsers = new HashMap<>();


   public BookingResponse.UserRegistrationResponse reegisterUser(User user){
       String userId = user.getUser_UUId();
       if(userId!=null){
           registeredUsers.put(userId, user);
           BookingResponse.UserRegistrationResponse registration = new BookingResponse.UserRegistrationResponse("User Registered Successfully", user);
           return  registration;
       }
       return  new BookingResponse.UserRegistrationResponse("User registration failed", user);

    }

    public boolean isRegistered(String userId){

        if(userId!=null && registeredUsers.get(userId)!=null){
            return  true;
     }
            return false;
    }


    public User retriveUser(String id){
        return registeredUsers.get(id);
    }


    public List<User> allRegisteredUsers(){
       return new  ArrayList<> (registeredUsers.values());
    }




}
