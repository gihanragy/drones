package com.musula.backend.drones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The Class User.
 */
@Entity(name = "Drone")
@Table(name = "Drone")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Drone implements Serializable {

    public int weight;
    @Id
    private String serialNumber;
    private Integer model;
    private Integer state;
    private float batteryCapacity;

}
