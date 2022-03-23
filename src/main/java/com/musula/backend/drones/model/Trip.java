package com.musula.backend.drones.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "Trip")
@Table(name = "Trip")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "droneID")
    @JsonBackReference
    private Drone drone;

    @OneToMany(
            cascade = CascadeType.PERSIST, mappedBy = "trip", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Medication> medicationSet;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
