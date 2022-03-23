package com.musula.backend.drones.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private float weight;

    @Lob
    private byte[] image;

    @OneToOne
    @JoinColumn(name = "activeTripID")
    @JsonBackReference
    private Trip trip;
}
