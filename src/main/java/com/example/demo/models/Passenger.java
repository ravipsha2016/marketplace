package com.example.demo.models;

public class Passenger {
    String name;
    Geneder gender;

    public String getName() {
        return name;
    }

    public Geneder getGender() {
        return gender;
    }

    public Passenger() {
    }

    public Passenger(String name, Geneder gender) {
        this.name = name;
        this.gender = gender;
    }
}
