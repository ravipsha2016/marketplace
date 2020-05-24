package com.example.demo.models;


import java.util.ArrayList;
import java.util.List;


public class Cab {
    private   String registrationNumber;
    public String model;
    public String color;
    private int capacity=4;

    public int getCapacity() {
        return capacity;
    }

    public int getCurrent_occupancy() {
        return current_occupancy;
    }

    private int current_occupancy;


    public void setCurrent_occupancy(int current_occupancy) {
        this.current_occupancy = current_occupancy;
    }

    private List<Seat> seatMatrix;

    public Cab(){
        this.capacity = 4;
        this.seatMatrix = new ArrayList<Seat>();

        for(int i=1 ; i<= capacity; i++ ){
            Seat seat = new Seat();
            seatMatrix.add(seat);
        }
    }
    public Cab(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        this.capacity = 4;
        this.seatMatrix = new ArrayList<Seat>();

        for(int i=1 ; i<= capacity; i++ ){
            Seat seat = new Seat();
            seatMatrix.add(seat);
        }

    }

   public boolean isFull(){
       return this.current_occupancy == this.capacity;
    }

    int numberOfAvailableSeats(){
        return  this.capacity - this.current_occupancy;
    }


    public List<Seat> getSeatMatrix() {
        return seatMatrix;
    }

    public Seat getAvailableSeat() {
        if (isFull()) {
            return null;
        }
        for (Seat seat : seatMatrix) {
            if (seat.isEmpty) {
                return seat;
            }
        }

        return  null;
    }


    public List<String> getTravellersList(){
        List<String> passengers = new ArrayList<>();
        for(Seat seat: seatMatrix){
            if(!seat.isEmpty){
                passengers.add(seat.getUser().getName());
            }
        }
        return passengers;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
