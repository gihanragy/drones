package com.musula.backend.drones.enums;

public enum DroneStateEnum {

    IDLE(1),
    LOADING(2),
    LOADED(3),
    DELIVERING(4),
    DELIVERED(5),
    RETURNING(6);

    private final int value;

    DroneStateEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
