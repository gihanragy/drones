package com.musula.backend.drones.service;


import com.musula.backend.constant.AppConstants;
import com.musula.backend.drones.converter.DroneConverters;
import com.musula.backend.drones.dto.DroneCreator;
import com.musula.backend.drones.dto.MedicationCreator;
import com.musula.backend.drones.dto.MedicationDTO;
import com.musula.backend.drones.model.Drone;
import com.musula.backend.drones.repository.DroneRepository;
import com.musula.backend.util.exception.DroneBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DroneServiceImpl implements DroneService {

    private static final Logger logger = LoggerFactory.getLogger(DroneServiceImpl.class);
    @Autowired
    DroneRepository droneRepository;


    @Transactional
    public void register(DroneCreator droneCreator) {
        if (droneRepository.findBySerialNumber(droneCreator.getSerialNumber()).isPresent())
            throw new DroneBadRequestException(AppConstants.SERIAL_NUMBER_ALREAY_REGISTERED);
        Drone drone = DroneConverters.droneConverter.apply(droneCreator);
        droneRepository.save(drone);
    }

    @Override
    public MedicationDTO createMedication(MedicationCreator input) {
        return null;
    }


}
