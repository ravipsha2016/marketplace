package com.example.demo.models;

public class Seat {
    public Boolean isEmpty;
    public Passenger passenger;

    public Boolean getEmpty() {
        return isEmpty;
    }

    public Seat() {
        this.isEmpty = true;
        this.passenger = null;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
