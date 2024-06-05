package com.fiap.app.app.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fiap.app.app.models.Drone;
import com.fiap.app.app.models.dto.DroneDto;
import com.fiap.app.app.repositories.DroneRepository;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DroneDto createDrone(DroneDto droneDto) {
        Drone drone = modelMapper.map(droneDto, Drone.class);
        droneRepository.save(drone);
        return modelMapper.map(drone, DroneDto.class);
    }

    public Page<DroneDto> getAllDrones(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Drone> dronePage = droneRepository.findAll(pageable);
        return dronePage.map(drone -> modelMapper.map(drone, DroneDto.class));
    }

    public Optional<DroneDto> getDroneById(Long droneId) {
        Optional<Drone> drone = droneRepository.findById(droneId);
        return drone.map(d -> modelMapper.map(d, DroneDto.class));
    }

    public DroneDto updateDrone(Long droneId, DroneDto droneDto) {
        Optional<Drone> optionalDrone = droneRepository.findById(droneId);
        if (optionalDrone.isPresent()) {
            Drone drone = optionalDrone.get();
            drone.setType(droneDto.getType());
            drone.setLocation(droneDto.getLocation());
            // Atualize outros campos conforme necessário
            Drone updatedDrone = droneRepository.save(drone);
            return modelMapper.map(updatedDrone, DroneDto.class);
        } else {
            return null;
        }
    }

    public void deleteDrone(Long droneId) {
        droneRepository.deleteById(droneId);
    }
}

