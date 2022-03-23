package com.musula.backend.drones.repository;

import com.musula.backend.drones.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicationRepository extends JpaRepository<Medication, Integer> {


}
