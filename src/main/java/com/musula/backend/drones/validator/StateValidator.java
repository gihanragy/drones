package com.musula.backend.drones.validator;

import com.musula.backend.drones.enums.DroneStateEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StateValidator implements ConstraintValidator<ValidState, Integer> {

    @Override
    public void initialize(ValidState constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        DroneStateEnum[] droneStateEnums = DroneStateEnum.values();
        for (DroneStateEnum stateEnum : droneStateEnums) {
            if (stateEnum.getValue() == value)
                return true;
        }
        return false;
    }
}
