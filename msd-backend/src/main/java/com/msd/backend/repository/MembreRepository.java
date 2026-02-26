package com.msd.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.msd.backend.entity.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MembreRepository extends JpaRepository<Membre, Long> {

    boolean existsByMatricule(String matricule);

    long count();

    /*
     * List<Membre> findByNomContainingIgnoreCase(String nom);
     * 
     * List<Membre> findByPrenomContainingIgnoreCase(String prenom);
     * 
     * List<Membre> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(String
     * nom, String prenom);
     */
    // Recherche par nom OU prénom (insensible à la casse)
    List<Membre> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(
            String nom,
            String prenom);

    Page<Membre> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(
            String nom,
            String prenom,
            Pageable pageable);

}
