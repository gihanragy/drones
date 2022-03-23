package com.musula.backend.drones.repository;

import com.musula.backend.drones.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TripRepository extends JpaRepository<Trip, Integer> {


}
