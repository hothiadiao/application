package com.msd.backend.controller;

import com.msd.backend.entity.AyantDroit;
import com.msd.backend.service.AyantDroitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ayant_droit")
@CrossOrigin(origins = "http://localhost:4200")
public class AyantDroitController {

    private final AyantDroitService service;

    public AyantDroitController(AyantDroitService service) {
        this.service = service;
    }

    @PostMapping("/{membreId}")
    public AyantDroit save(@PathVariable Long membreId,
            @RequestBody AyantDroit ayantDroit) {
        return service.saveAyantDroit(membreId, ayantDroit);
    }

    @GetMapping("/{membreId}")
    public List<AyantDroit> getByMembre(@PathVariable Long membreId) {
        return service.getAyantsDroit(membreId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAyantDroit(id);
    }
}
