package com.fiap.app.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fiap.app.app.models.Garbage;
import com.fiap.app.app.models.dto.GarbageDto;
import com.fiap.app.app.repositories.GarbageRepository;

@Service
public class GarbageService {

    @Autowired
    private GarbageRepository garbageRepository;

    @Autowired
    private ModelMapper modelMapper;

    public GarbageDto createGarbage(GarbageDto garbageDto) {
        Garbage garbage = modelMapper.map(garbageDto, Garbage.class);
        garbageRepository.save(garbage);
        return modelMapper.map(garbage, GarbageDto.class);
    }

    public List<GarbageDto> getAllGarbages() {
        List<Garbage> garbages = garbageRepository.findAll();
        return garbages.stream()
                       .map(garbage -> modelMapper.map(garbage, GarbageDto.class))
                       .collect(Collectors.toList());
    }

    public Optional<GarbageDto> getGarbageById(Long garbageId) {
        Optional<Garbage> garbage = garbageRepository.findById(garbageId);
        return garbage.map(g -> modelMapper.map(g, GarbageDto.class));
    }

    public Page<GarbageDto> getGarbageByDroneId(Long droneId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Garbage> garbagePage = garbageRepository.findByDroneDroneId(droneId, pageable);
        return garbagePage.map(garbage -> modelMapper.map(garbage, GarbageDto.class));
    }

    public GarbageDto updateGarbage(Long garbageId, GarbageDto garbageDto) {
        Optional<Garbage> optionalGarbage = garbageRepository.findById(garbageId);
        if (optionalGarbage.isPresent()) {
            Garbage garbage = optionalGarbage.get();
            garbage.setLatitude(garbageDto.getLatitude());
            garbage.setLongitude(garbageDto.getLongitude());
            garbage.setDepth(garbageDto.getDepth());
            garbage.setDate(garbageDto.getDate());
            garbage.setDrone(garbageDto.getDrone());
            Garbage updatedGarbage = garbageRepository.save(garbage);
            return modelMapper.map(updatedGarbage, GarbageDto.class);
        } else {
            return null;
        }
    }

    public void deleteGarbage(Long garbageId) {
        garbageRepository.deleteById(garbageId);
    }
}

