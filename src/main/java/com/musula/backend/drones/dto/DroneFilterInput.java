package com.musula.backend.drones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.musula.backend.drones.enums.DroneStateEnum;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DroneFilterInput {
    DroneStateEnum droneStateEnum;
    Float batteryLevel;
}
