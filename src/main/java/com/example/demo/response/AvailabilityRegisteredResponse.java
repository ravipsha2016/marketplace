package com.example.demo.response;

import com.example.demo.models.Cab;

public class AvailabilityRegisteredResponse {
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

    public AvailabilityRegisteredResponse(Cab cab, String status) {
        this.registrationNumber = cab.registrationNumber;
        this.status = status;
    }
}
