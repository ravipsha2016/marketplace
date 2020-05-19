package com.example.demo.models;


import java.util.ArrayList;
import java.util.List;


public class Cab {
    public  String registrationNumber;
    public String model;
    public String color;
    public int capacity=4;
    public int current_occupancy;
    public List<Seat> seatMatrix;

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
                passengers.add(seat.getPassenger().getName());
            }
        }
        return passengers;
    }


}
