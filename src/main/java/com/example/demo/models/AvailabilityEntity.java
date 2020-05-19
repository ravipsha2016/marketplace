package com.example.demo.models;

public class AvailabilityEntity {
    Cab cab;
    Seat seat;

    public AvailabilityEntity(Cab cab, Seat seat) {
        this.cab = cab;
        this.seat = seat;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
