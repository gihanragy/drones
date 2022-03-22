package com.musula.backend.drones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Class Medication.
 */
@Entity(name = "Medication")
@Table(name = "Medication")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medication implements Serializable {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private int model;

    @Column(name = "weight")
    private float weight;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
