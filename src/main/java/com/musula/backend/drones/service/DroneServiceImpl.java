package com.musula.backend.drones.service;


import com.musula.backend.constant.AppConstants;
import com.musula.backend.drones.converter.DroneConverters;
import com.musula.backend.drones.dto.DroneCreator;
import com.musula.backend.drones.dto.MedicationCreator;
import com.musula.backend.drones.dto.MedicationDTO;
import com.musula.backend.drones.dto.TripCreater;
import com.musula.backend.drones.enums.DroneStateEnum;
import com.musula.backend.drones.model.Drone;
import com.musula.backend.drones.model.Medication;
import com.musula.backend.drones.model.Trip;
import com.musula.backend.drones.repository.DroneRepository;
import com.musula.backend.drones.repository.MedicationRepository;
import com.musula.backend.drones.repository.TripRepository;
import com.musula.backend.util.exception.DroneBadRequestException;
import com.musula.backend.util.exception.DroneNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class DroneServiceImpl implements DroneService {

    private static final Logger logger = LoggerFactory.getLogger(DroneServiceImpl.class);
    @Autowired
    DroneRepository droneRepository;
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    TripRepository tripRepository;

    @Transactional
    public void register(DroneCreator droneCreator) {
        if (droneRepository.findBySerialNumber(droneCreator.getSerialNumber()).isPresent())
            throw new DroneBadRequestException(AppConstants.SERIAL_NUMBER_ALREAY_REGISTERED);
        Drone drone = DroneConverters.droneConverter.apply(droneCreator);
        droneRepository.save(drone);
    }

    @Override
    public MedicationDTO createMedication(MedicationCreator input) {
        Medication medication = DroneConverters.medicationConverter.apply(input);
        try {
            medication.setImage(input.getFile().getBytes());
        } catch (IOException e) {
            throw new DroneBadRequestException(AppConstants.INVALID_FILE_FORMAT);
        }
        medicationRepository.save(medication);
        return DroneConverters.medicationDTOConverter.apply(medication);
    }

    @Override
    public Trip loadDroneWithItems(TripCreater tripCreater) {
       Optional<Drone> droneOptional= droneRepository.findById(tripCreater.getDroneId());
       if(!droneOptional.isPresent())
           throw  new DroneNotFoundException(AppConstants.DRONE_ID_NOT_FOUND);
       Drone drone = droneOptional.get();
       if(drone.getState()!= DroneStateEnum.IDLE.getValue())
           throw  new DroneBadRequestException(AppConstants.DRONE_CANT_LOADED_IN_THIS_STATE);

        if(drone.getBatteryCapacity()<25)
            throw  new DroneBadRequestException(AppConstants.DRONE_LOW_BATTERY);
       Set<Medication> medicationSet=new HashSet<>();
       float totalWeight=0;
        Trip trip = new Trip();
       for(Integer medicationID:tripCreater.getMedicationIDList())
       {
           Medication medication = medicationRepository.findById(medicationID).orElseThrow(() -> new DroneNotFoundException(AppConstants.MEDICATION_ID_NOT_FOUND));
           totalWeight+=medication.getWeight();
           medicationSet.add(medication);
           medication.setTrip(trip);
       }
       if(totalWeight>drone.getWeight())
           throw new DroneBadRequestException(AppConstants.TOTAL_WEIGHT_GREATER_THAN_ERROR);
       trip.setDrone(drone);
       trip.setMedicationSet(medicationSet);
        tripRepository.save(trip);
        return trip;
    }


}
