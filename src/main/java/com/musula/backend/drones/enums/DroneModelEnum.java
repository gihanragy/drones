package com.musula.backend.drones.enums;

public enum DroneModelEnum {
    Lightweight(1),
    Middleweight(2),
    Cruiserweight(3),
    Heavyweight(4);

    private final int value;

    DroneModelEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
