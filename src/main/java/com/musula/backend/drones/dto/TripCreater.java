package com.musula.backend.drones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TripCreater {
    private Integer droneId;
    private List<Integer> medicationID;
}
