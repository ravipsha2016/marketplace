package com.example.demo.response;

import java.util.List;

public class BookingResponse {
    String status;
    Boolean isLastPassenger;
    List<String>fellow_travellers;
    String registrationNumber;
    boolean waitingForMorePassengers;


    public boolean isWaitingForMorePassengers() {
        return waitingForMorePassengers;
    }

    public void setWaitingForMorePassengers(boolean waitingForMorePassengers) {
        this.waitingForMorePassengers = waitingForMorePassengers;
    }


    public BookingResponse(String status, Boolean isLastPassenger, List<String> fellow_travellers, String registrationNumber, boolean waitingForMorePassengers) {
        this.status = status;
        this.isLastPassenger = isLastPassenger;
        this.fellow_travellers = fellow_travellers;
        this.registrationNumber = registrationNumber;
        this.waitingForMorePassengers = waitingForMorePassengers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getLastPassenger() {
        return isLastPassenger;
    }

    public void setLastPassenger(Boolean lastPassenger) {
        isLastPassenger = lastPassenger;
    }

    public List<String> getFellow_travellers() {
        return fellow_travellers;
    }

    public void setFellow_travellers(List<String> fellow_travellers) {
        this.fellow_travellers = fellow_travellers;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


}
