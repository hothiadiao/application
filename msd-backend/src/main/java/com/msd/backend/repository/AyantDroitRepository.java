package com.msd.backend.repository;

import com.msd.backend.entity.AyantDroit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AyantDroitRepository extends JpaRepository<AyantDroit, Long> {
    List<AyantDroit> findByMembreId(Long membreId);
}
