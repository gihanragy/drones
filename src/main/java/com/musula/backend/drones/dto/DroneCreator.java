package com.musula.backend.drones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.musula.backend.constant.AppConstants;
import com.musula.backend.drones.validator.ValidDroneModel;
import com.musula.backend.drones.validator.ValidState;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DroneCreator {
    @Positive(message = AppConstants.WEIGHT_RANGE_ERROR_MESSAGE)
    @Max(value = 500, message = AppConstants.WEIGHT_RANGE_ERROR_MESSAGE)
    public int weight;
    @Size(min = 1, max = 100, message = AppConstants.SERIAL_LENGTH_MIN_MAX)
    private String serialNumber;
    @ValidDroneModel(message = AppConstants.DRONE_MODEL_VALUE)
    private Integer model;
    @ValidState(message = AppConstants.STATE_NOT_VALID)
    private Integer state;
    @Positive(message = AppConstants.WEIGHT_RANGE_ERROR_MESSAGE)
    @Max(value = 100, message = AppConstants.WEIGHT_RANGE_ERROR_MESSAGE)
    private float batteryCapacity;

}
