package com.msd.backend.repository;

import com.msd.backend.entity.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<Membre, Long> {

    boolean existsByMatricule(String matricule);

    long count();
}
