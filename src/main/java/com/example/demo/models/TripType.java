package com.example.demo.models;

public enum TripType {
    SHARED(1),
    INDIVIDUAL(2);

    private int value ;

    private TripType(int i) {
        this.value =i;
    }

    public  int getValue(){
        return this.value;
    }
}
