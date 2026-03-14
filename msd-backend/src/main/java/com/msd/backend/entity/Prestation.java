package com.msd.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prestations")
public class Prestation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private double montant;
    private String description;
    private String statut;

    // Relation avec Membre
    @ManyToOne
    @JoinColumn(name = "membre_id")
    private Membre membre;

    // Constructeur vide
    public Prestation() {
    }

    // Constructeur avec paramètres
    public Prestation(Long id, String type, double montant, String description, String statut, Membre membre) {
        this.id = id;
        this.type = type;
        this.montant = montant;
        this.description = description;
        this.statut = statut;
        this.membre = membre;
    }

    // GETTERS ET SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }
}