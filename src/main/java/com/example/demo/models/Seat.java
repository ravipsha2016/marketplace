package com.example.demo.models;

public class Seat {
    public Boolean isEmpty;
    public User user;

    public Boolean getEmpty() {
        return isEmpty;
    }

    public Seat() {
        this.isEmpty = true;
        this.user = null;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
