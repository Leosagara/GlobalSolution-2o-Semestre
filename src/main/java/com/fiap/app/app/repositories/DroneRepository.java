package com.fiap.app.app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.app.app.models.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone,Long>{
    
}
