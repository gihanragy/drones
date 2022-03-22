package com.musula.backend.drones.service;


import com.musula.backend.drones.dto.DroneCreator;
import com.musula.backend.drones.repository.DroneRepository;
import com.musula.backend.util.exception.DroneBadRequestException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DroneServiceImpl implements DroneService {

    private static final Logger logger = LoggerFactory.getLogger(DroneServiceImpl.class);
    /**
     * The user repository.
     */
    @Autowired
    DroneRepository droneRepository;




    @Autowired
    ModelMapper modelMapper;




    /**
     * Save.
     *
     * @param droneCreator the user
     * @throws DroneBadRequestException the bad request exception
     */
    @Transactional
    public void register(DroneCreator droneCreator) {

    }


}
