package com.example.demo.aspects;

import com.example.demo.services.UserRegistrationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WalletValidationAspect {

    private UserRegistrationService userRegistrationService;
    private Object Throwable;

    @Autowired
    WalletValidationAspect(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
    }


    @Pointcut("execution(* com.example.demo.controller.BookingController.bookCab(..))")
    public void controllerBookingMethod() {}


    /* To be implemented for validating the customer wallet*/
    @Before("controllerBookingMethod()")
    public void validatePassengerRegistration(JoinPoint joinPoint)
    {

    }


}




