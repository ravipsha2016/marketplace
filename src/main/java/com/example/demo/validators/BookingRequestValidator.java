package com.example.demo.validators;

import com.example.demo.exceptions.ValidationException;
import com.example.demo.models.TripType;
import com.example.demo.services.UserRegistrationService;
import org.springframework.stereotype.Component;
import requests.BookingRequest;

@Component
public class BookingRequestValidator{

    private UserRegistrationService userRegistrationService;
    BookingRequestValidator(UserRegistrationService userRegistrationService){
        this.userRegistrationService= userRegistrationService;
    }


    public boolean validate(BookingRequest request) throws ValidationException {
       String userId =  request.getUser_uuid();
       if (!userRegistrationService.isRegistered(userId)){
           throw new ValidationException("User is not registered with platform");
       }
       if(request.getTripType()==null){
           throw new ValidationException("Trip-Type can not be empty");
       }
        if(request.getTripType()!= TripType.INDIVIDUAL && request.getTripType()!=TripType.SHARED){
            throw new ValidationException("Trip-Type should either be INDIVIDUAL or SHARED ");
        }
        if(request.getDestination() ==null){
            throw new ValidationException("Trip destination can not be empty");
        }

        return true;
    }
}
