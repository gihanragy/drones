package com.musula.backend.drones.repository;

import com.musula.backend.drones.model.Drone;
import com.musula.backend.drones.model.QDrone;
import com.musula.backend.util.repository.QueryDslPagingAndSortingRepository;


public interface DroneRepository extends QueryDslPagingAndSortingRepository<Drone, Long, QDrone> {

}
