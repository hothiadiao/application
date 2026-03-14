package com.msd.backend.service;

import org.springframework.data.domain.Page;
import com.msd.backend.entity.Prestation;

public interface PrestationService {

    Prestation save(Prestation prestation);

    Page<Prestation> getAll(int page, int size, String keyword);

    Prestation update(Long id, Prestation prestation);

    void delete(Long id);
}