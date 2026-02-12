package com.msd.backend.service;

import com.msd.backend.entity.AyantDroit;
import com.msd.backend.entity.Membre;
import com.msd.backend.repository.AyantDroitRepository;
import com.msd.backend.repository.MembreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AyantDroitService {

    private final AyantDroitRepository ayantDroitRepository;
    private final MembreRepository membreRepository;

    public AyantDroitService(AyantDroitRepository repo, MembreRepository membreRepo) {
        this.ayantDroitRepository = repo;
        this.membreRepository = membreRepo;
    }

    public AyantDroit saveAyantDroit(Long membreId, AyantDroit ayantDroit) {
        Membre membre = membreRepository.findById(membreId)
                .orElseThrow(() -> new RuntimeException("Membre non trouvé"));

        ayantDroit.setMembre(membre);

        return ayantDroitRepository.save(ayantDroit);
    }

    public List<AyantDroit> getAyantsDroit(Long membreId) {
        return ayantDroitRepository.findByMembreId(membreId);
    }

    public void deleteAyantDroit(Long id) {
        ayantDroitRepository.deleteById(id);
    }
}
