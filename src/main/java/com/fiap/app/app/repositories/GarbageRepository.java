package com.fiap.app.app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.app.app.models.Garbage;

@Repository
public interface GarbageRepository extends JpaRepository<Garbage,Long>{
    Page<Garbage> findByDroneDroneId(Long droneId, Pageable pageable);
}
