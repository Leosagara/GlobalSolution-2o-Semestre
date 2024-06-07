package com.fiap.app.app.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="drone")
public class Drone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long droneId;

    private String type; 

    private String location;

    @OneToMany(mappedBy = "drone")
    private List<Garbage> garbageList;
}
