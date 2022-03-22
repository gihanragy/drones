package com.musula.backend.drones.validator;

import com.musula.backend.drones.enums.DroneModelEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DroneModelValidator implements ConstraintValidator<ValidDroneModel, Integer> {

    @Override
    public void initialize(ValidDroneModel constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        DroneModelEnum[] allAvailableModel = DroneModelEnum.values();
        for (DroneModelEnum model : allAvailableModel) {
            if (model.getValue() == value)
                return true;
        }
        return false;
    }
}
