package com.example.demo.controller;

import com.example.demo.models.Cab;
import com.example.demo.response.RegisteredAvailabilityResponse;
import com.example.demo.services.AvailabilityService;
import com.example.demo.services.CabRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CabAvailabilityController {

    private AvailabilityService availabilityService;
    private CabRegisterService registerService;

    @Autowired
    CabAvailabilityController(AvailabilityService availabilityService, CabRegisterService registerService){
        this.availabilityService = availabilityService;
        this.registerService = registerService;
    }

    @RequestMapping(value = "/register/availability", method = RequestMethod.POST)
    ResponseEntity<RegisteredAvailabilityResponse> registerAvailability(@RequestBody Cab cab){
      RegisteredAvailabilityResponse response=  availabilityService.registerAvailability(cab);
      return new ResponseEntity<RegisteredAvailabilityResponse>(response, HttpStatus.OK);
    }
}
