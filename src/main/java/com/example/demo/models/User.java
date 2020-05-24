package com.example.demo.models;

import java.io.Serializable;
import java.util.UUID;

public class User  implements Serializable {

    public Gender gender;
    public String name;
    private String user_UUId;


    public User() {
        this.user_UUId = UUID.randomUUID().toString();
    }

    public User(String name, Gender gender) {
        this.user_UUId = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
    }

    public String getUser_UUId() {
        return user_UUId;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }
}
