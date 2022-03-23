package com.musula.backend.drones.controller;

import com.musula.backend.drones.dto.DroneCreator;
import com.musula.backend.drones.dto.MedicationCreator;
import com.musula.backend.drones.service.DroneService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The Class UserController.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/drone")
public class DroneController {


    @Autowired
    DroneService droneService;




    @Operation(summary = "status = 403, message = Access Denied" + "\n"
            + "\n", description = "This API is used to register new drone")
    @PostMapping("/register")
    public  ResponseEntity<?> register(@Valid @RequestBody DroneCreator droneCreator) {
        droneService.register(droneCreator);
        return ResponseEntity.accepted().build();

    }

    @Operation(summary = "status = 403, message = Access Denied" + "\n"
            + "\n", description = "This API create new Medication")
    @PostMapping(value = "/medication/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> createNewMedication(@Valid @ModelAttribute MedicationCreator input) {
        droneService.createMedication(input);
        return ResponseEntity.accepted().build();

    }


}
