package com.example.demo.response;

import com.example.demo.models.Cab;

public class RegisteredAvailabilityResponse {
    String registrationNumber;
    String status;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RegisteredAvailabilityResponse(Cab cab, String status) {
        this.registrationNumber = cab.getRegistrationNumber();
        this.status = status;
    }
}
