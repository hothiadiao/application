package com.msd.backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.msd.backend.entity.Membre;
import com.msd.backend.repository.MembreRepository;
import com.msd.backend.service.MembreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membre") // ✅ URL PRINCIPALE
public class MembreController {

    private final MembreService membreService;

    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    // ✅ ENREGISTRER UN MEMBRE
    // POST http://localhost:8080/api/membre
    @PostMapping
    public Membre createMembre(@RequestBody Membre membre) {
        return membreService.createMembre(membre);
    }

    // ✅ LISTE DES MEMBRES
    // GET http://localhost:8080/api/membre
    // Pour la pagination
    /*
     * @GetMapping
     * public List<Membre> getAllMembre() {
     * return membreService.getAllMembre();
     * }
     */
    @GetMapping("/membre")
    public Page<Membre> getAllMembre(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String keyword) {

        Pageable pageable = PageRequest.of(page, size);

        if (keyword != null && !keyword.isEmpty()) {
            return membreRepository
                    .findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(
                            keyword, keyword, pageable);
        }

        return membreRepository.findAll(pageable);
    }

    // ✅ UN MEMBRE PAR ID
    // GET http://localhost:8080/api/membre/1
    @GetMapping("/{id}")
    public Membre getMembreById(@PathVariable Long id) {
        return membreService.getMembreById(id);
    }

    @PutMapping("/{id}")
    public Membre updateMembre(@PathVariable Long id, @RequestBody Membre membre) {
        return membreService.updateMembre(id, membre);
    }

    // ✅ SUPPRIMER UN MEMBRE
    // DELETE http://localhost:8080/api/membre/1
    @DeleteMapping("/{id}")
    public void deleteMembre(@PathVariable Long id) {
        membreService.deleteMembre(id);
    }

    @Autowired
    private MembreRepository membreRepository;

    /*
     * @GetMapping("/search")
     * public List<Membre> searchMembre(@RequestParam String keyword) {
     * return membreRepository
     * .findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(keyword, keyword);
     * }
     */
    // 🔎 Recherche
    @GetMapping("/search")
    public List<Membre> searchMembres(@RequestParam String keyword) {
        return membreService.searchMembres(keyword);
    }

    // Pagination
    /*
     * @GetMapping("/membre")
     * public Page<Membre> getMembre(
     * 
     * @RequestParam(defaultValue = "0") int page,
     * 
     * @RequestParam(defaultValue = "5") int size,
     * 
     * @RequestParam(required = false) String keyword) {
     * 
     * Pageable pageable = PageRequest.of(page, size);
     * 
     * if (keyword != null && !keyword.isEmpty()) {
     * return membreRepository
     * .findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(
     * keyword, keyword, pageable);
     * }
     * 
     * return membreRepository.findAll(pageable);
     * }
     */

}
