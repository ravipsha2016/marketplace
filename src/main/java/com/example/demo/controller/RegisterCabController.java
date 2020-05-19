package com.example.demo.controller;


import com.example.demo.models.Cab;
import com.example.demo.services.CabRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterCabController {
    private CabRegisterService cabRegisterService;

    @Autowired
    RegisterCabController(CabRegisterService cabRegisterService){
        this.cabRegisterService = cabRegisterService;
    }


    @RequestMapping(value = "/register/cab", method = RequestMethod.POST)
    void registerCab(@RequestBody Cab cab) {
        cabRegisterService.registerCabWithAggregator(cab);
    }


    @GetMapping("/cabs")
    List<Cab> registeredCabs() {
       return cabRegisterService.getAllRegisteredCabs();
    }


}
