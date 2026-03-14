package com.msd.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.msd.backend.entity.Prestation;

public interface PrestationRepository extends JpaRepository<Prestation, Long> {

    Page<Prestation> findByTypeContaining(String keyword, Pageable pageable);
}