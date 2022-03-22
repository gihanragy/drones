package com.musula.backend.drones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Id;


/**
 * The DTO Class User.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class MedicationCreator {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private int model;

    private float weight;

    private MultipartFile file;

}
