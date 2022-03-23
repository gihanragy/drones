package com.musula.backend.drones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "Drone")
@Table(name = "Drone")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Drone implements Serializable {
    public int weight;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serialNumber;
    private Integer model;
    private Integer state;
    private float batteryCapacity;

}
