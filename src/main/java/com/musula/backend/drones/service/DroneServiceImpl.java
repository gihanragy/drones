package com.musula.backend.drones.service;


import com.musula.backend.constant.AppConstants;
import com.musula.backend.drones.converter.DroneConverters;
import com.musula.backend.drones.dto.DroneCreator;
import com.musula.backend.drones.dto.MedicationCreator;
import com.musula.backend.drones.dto.MedicationDTO;
import com.musula.backend.drones.model.Drone;
import com.musula.backend.drones.model.Medication;
import com.musula.backend.drones.repository.DroneRepository;
import com.musula.backend.drones.repository.MedicationRepository;
import com.musula.backend.util.exception.DroneBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Service
public class DroneServiceImpl implements DroneService {

    private static final Logger logger = LoggerFactory.getLogger(DroneServiceImpl.class);
    @Autowired
    DroneRepository droneRepository;
    @Autowired
    MedicationRepository medicationRepository;

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





}
