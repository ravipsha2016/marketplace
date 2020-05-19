package com.example.demo.models;

import java.io.Serializable;

public class Passenger  implements Serializable {
    String name;
    Geneder gender;

    public String getName() {
        return name;
    }

    public Geneder getGender() {
        return gender;
    }

    public Passenger(String name, Geneder gender) {
        this.name = name;
        this.gender = gender;
    }
}
