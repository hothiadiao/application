
package com.msd.backend.service;

import com.msd.backend.entity.Membre;
import com.msd.backend.repository.MembreRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class MembreService {

    private final MembreRepository membreRepository;

    public MembreService(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    // ✅ CRÉER MEMBRE + MATRICULE AUTO
    public Membre createMembre(Membre membre) {

        int year = Year.now().getValue();

        // nombre total de membres
        long count = membreRepository.count() + 1;

        // format MYF-2026-0001
        String matricule = String.format("MYF-%d-%04d", year, count);

        membre.setMatricule(matricule);

        return membreRepository.save(membre);
    }

    // ✅ LISTE MEMBRES
    public List<Membre> getAllMembre() {
        return membreRepository.findAll();
    }

    // ✅ MEMBRE PAR ID
    public Membre getMembreById(Long id) {
        return membreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membre non trouvé"));
    }
    // MODIFIER

    public Membre updateMembre(Long id, Membre membreDetails) {

        Membre membre = membreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membre non trouvé"));

        membre.setPrenom(membreDetails.getPrenom());
        membre.setNom(membreDetails.getNom());
        membre.setDateNaissance(membreDetails.getDateNaissance());
        membre.setTelephone(membreDetails.getTelephone());
        membre.setAdresse(membreDetails.getAdresse());
        membre.setAntenne(membreDetails.getAntenne());

        return membreRepository.save(membre);
    }

    // ✅ SUPPRIMER
    public void deleteMembre(Long id) {
        membreRepository.deleteById(id);
    }
}
