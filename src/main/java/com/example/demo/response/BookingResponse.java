package com.example.demo.response;

import com.example.demo.models.Passenger;

import java.util.List;

public class BookingResponse {
    String status;
    Boolean isLastPassenger;
    List<String>fellow_travellers;

    public BookingResponse(String status, Boolean isLastPassenger, List<String> fellow_travellers) {
        this.status = status;
        this.isLastPassenger = isLastPassenger;
        this.fellow_travellers = fellow_travellers;
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
}
