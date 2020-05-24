package com.example.demo.models;

public enum Gender {
    MALE(0),
    FEMALE(1);

    private int value ;

    private Gender(int i) {
        this.value =i;
    }

    public  int getValue(){
        return this.value;
    }
}
