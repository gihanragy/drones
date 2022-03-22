package com.musula.backend.drones.service;

import com.musula.backend.drones.dto.DroneCreator;
import com.musula.backend.drones.dto.MedicationCreator;
import com.musula.backend.drones.dto.MedicationDTO;

public interface DroneService {
    void register(DroneCreator droneCreator);


    MedicationDTO createMedication(MedicationCreator input);
}
