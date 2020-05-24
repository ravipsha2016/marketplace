package com.example.demo.response;

import com.example.demo.models.User;

import java.io.Serializable;
import java.util.List;

public class BookingResponse {
    String status;
    Boolean isLastPassenger;
    List<String>fellow_travellers;
    String registrationNumber;
    boolean waitingForMorePassengers;
    User user;


    public boolean isWaitingForMorePassengers() {
        return waitingForMorePassengers;
    }

    public void setWaitingForMorePassengers(boolean waitingForMorePassengers) {
        this.waitingForMorePassengers = waitingForMorePassengers;
    }


    public BookingResponse(String status, Boolean isLastPassenger, List<String> fellow_travellers, String registrationNumber, boolean waitingForMorePassengers, User user) {
        this.status = status;
        this.isLastPassenger = isLastPassenger;
        this.fellow_travellers = fellow_travellers;
        this.registrationNumber = registrationNumber;
        this.waitingForMorePassengers = waitingForMorePassengers;
        this.user= user;
    }

    public BookingResponse(String status){
        this.status=status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


    public static class UserRegistrationResponse implements Serializable {
        String registration_status;
        User user;

        public UserRegistrationResponse(String registration_status, User user) {
            this.registration_status = registration_status;
            this.user = user;
        }

        public String getRegistration_status() {
            return registration_status;
        }

        public void setRegistration_status(String registration_status) {
            this.registration_status = registration_status;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}
