package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Department {

    COMPUTER("COMPUTER"),CIVIL("CIVIL"),MECHANICAL("MECHANICAL"),ELECTRICAL("ELECTRICAL"),IT("IT"),AUTOMOBILE("AUTOMOBILE");

    private String name;
    Department(String name)
    {
        this.name = name;
    }
    @JsonValue
    public String getName() {
        return name;
    }
}
