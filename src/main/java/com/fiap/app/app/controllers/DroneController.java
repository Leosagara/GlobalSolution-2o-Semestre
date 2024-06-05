package com.fiap.app.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fiap.app.app.models.dto.DroneDto;
import com.fiap.app.app.services.DroneService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;
    
    @PostMapping
    public ResponseEntity<DroneDto> createDrone(@RequestBody @Valid DroneDto droneDto) {        
        DroneDto droneDtoCreated = droneService.createDrone(droneDto);
        return ResponseEntity.ok(droneDtoCreated); 
    }

    @GetMapping
    public String getAllDrones(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {
        Page<DroneDto> dronePage = droneService.getAllDrones(page, size);
        model.addAttribute("dronePage", dronePage);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        return "drones";
    }

    @GetMapping("/{id}")
    public ResponseEntity<DroneDto> getDroneById(@PathVariable Long id) {
        Optional<DroneDto> droneDto = droneService.getDroneById(id);
        if (droneDto.isPresent()) {
            return ResponseEntity.ok(droneDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DroneDto> updateDrone(@PathVariable Long id, @RequestBody @Valid DroneDto droneDto) {
        DroneDto updatedDroneDto = droneService.updateDrone(id, droneDto);
        if (updatedDroneDto != null) {
            return ResponseEntity.ok(updatedDroneDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(@PathVariable Long id) {
        droneService.deleteDrone(id);
        return ResponseEntity.noContent().build();
    }
}
