package com.musula.backend.drones.converter;

import com.musula.backend.drones.dto.DroneCreator;
import com.musula.backend.drones.dto.MedicationCreator;
import com.musula.backend.drones.dto.MedicationDTO;
import com.musula.backend.drones.model.Drone;
import com.musula.backend.drones.model.Medication;
import com.musula.backend.util.ModelMapperUtil;

import java.util.function.Function;

public class DroneConverters {
    public static final Function<Medication, MedicationDTO> medicationDTOConverter = medication -> ModelMapperUtil.getInstance().map(medication, MedicationDTO.class);

    public static final Function<MedicationCreator, Medication> medicationConverter = medicationCreator -> ModelMapperUtil.getInstance().map(medicationCreator, Medication.class);

    public static final Function<DroneCreator, Drone> droneConverter = droneCreator -> ModelMapperUtil.getInstance().map(droneCreator, Drone.class);

    private DroneConverters() {
    }
}
