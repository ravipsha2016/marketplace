package com.example.demo.response;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;

import java.util.UUID;

public class CabRegistrationResponse {
    String registrationNumber;
    UUID cab_uuid;

    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
