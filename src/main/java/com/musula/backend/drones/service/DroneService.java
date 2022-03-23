package com.musula.backend.drones.service;

import com.musula.backend.drones.dto.*;
import com.musula.backend.drones.model.Drone;
import com.musula.backend.drones.model.Trip;

public interface DroneService {
    void register(DroneCreator droneCreator);


    MedicationDTO createMedication(MedicationCreator input);

    Trip loadDroneWithItems(TripCreater tripCreater);

    Iterable<Drone> getAllAvailable();
}
