package com.msd.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.msd.backend.entity.Prestation;
import com.msd.backend.repository.PrestationRepository;

@Service
public class PrestationServiceImpl implements PrestationService {

    private final PrestationRepository repository;

    // Constructeur pour injecter le repository
    public PrestationServiceImpl(PrestationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Prestation save(Prestation prestation) {
        return repository.save(prestation);
    }

    @Override
    public Page<Prestation> getAll(int page, int size, String keyword) {

        Pageable pageable = PageRequest.of(page, size);

        if (keyword != null && !keyword.isEmpty()) {
            return repository.findByTypeContaining(keyword, pageable);
        }

        return repository.findAll(pageable);
    }

    @Override
    public Prestation update(Long id, Prestation prestation) {

        Prestation existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestation non trouvée"));

        existing.setType(prestation.getType());
        existing.setMontant(prestation.getMontant());
        existing.setDescription(prestation.getDescription());
        existing.setStatut(prestation.getStatut());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}