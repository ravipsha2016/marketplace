package com.example.demo.controller;


import com.example.demo.models.Cab;
import com.example.demo.response.CabRegistrationResponse;
import com.example.demo.models.User;
import com.example.demo.response.BookingResponse;
import com.example.demo.services.CabRegisterService;
import com.example.demo.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterController {
    private CabRegisterService cabRegisterService;
    private UserRegistrationService userRegistrationService;

    @Autowired
    RegisterController(CabRegisterService cabRegisterService, UserRegistrationService userRegistrationService){
        this.cabRegisterService = cabRegisterService;
        this.userRegistrationService = userRegistrationService;

    }


    @RequestMapping(value = "/register/cab", method = RequestMethod.POST)
    void registerCab(@RequestBody Cab cab) {
        cabRegisterService.registerCabWithAggregator(cab);
    }

    @RequestMapping(value = "/register/user", method = RequestMethod.POST)
    ResponseEntity<BookingResponse.UserRegistrationResponse> registerPassenger(@RequestBody User user){
        BookingResponse.UserRegistrationResponse response= userRegistrationService.reegisterUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @RequestMapping(value = "/cabs", method = RequestMethod.GET)
    ResponseEntity<List<CabRegistrationResponse>>getRegisteredCabs() {
        List<CabRegistrationResponse> registered_cabs= cabRegisterService.getAllRegisteredCabs();
        return new ResponseEntity<>(registered_cabs, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<List<User>> getRegisteredUsers(){
        List<User> users = userRegistrationService.allRegisteredUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }



}
