package com.fiap.app.app.controllers;

import java.util.List;
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

import com.fiap.app.app.models.dto.GarbageDto;
import com.fiap.app.app.services.GarbageService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/garbages")
public class GarbageController {
    
    @Autowired
    private GarbageService garbageService;

    @PostMapping
    public ResponseEntity<GarbageDto> createGarbage(@RequestBody @Valid GarbageDto garbageDto) {
        GarbageDto createdGarbage = garbageService.createGarbage(garbageDto);
        return ResponseEntity.ok(createdGarbage);
    }

    @GetMapping
    public ResponseEntity<List<GarbageDto>> getAllGarbages() {
        List<GarbageDto> garbages = garbageService.getAllGarbages();
        return ResponseEntity.ok(garbages);
    }

    @GetMapping("/detections/{droneId}")
    public String getGarbageDetails(
            @PathVariable("droneId") Long droneId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        Page<GarbageDto> garbagePage = garbageService.getGarbageByDroneId(droneId, page, size);
        model.addAttribute("garbagePage", garbagePage);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("droneId", droneId); 

        return "garbages"; 
    }

    @GetMapping("/{id}")
    public ResponseEntity<GarbageDto> getGarbageById(@PathVariable Long id) {
        Optional<GarbageDto> garbageDto = garbageService.getGarbageById(id);
        if (garbageDto.isPresent()) {
            return ResponseEntity.ok(garbageDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GarbageDto> updateGarbage(@PathVariable Long id, @RequestBody @Valid GarbageDto garbageDto) {
        GarbageDto updatedGarbageDto = garbageService.updateGarbage(id, garbageDto);
        if (updatedGarbageDto != null) {
            return ResponseEntity.ok(updatedGarbageDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarbage(@PathVariable Long id) {
        garbageService.deleteGarbage(id);
        return ResponseEntity.noContent().build();
    }
}
