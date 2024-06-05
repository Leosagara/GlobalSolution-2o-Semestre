package com.fiap.app.app.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Garbage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long garbageId;

    private double latitude;

    private double longitude;

    private double depth;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "droneId")
    @JsonIgnore
    private Drone drone;
}
