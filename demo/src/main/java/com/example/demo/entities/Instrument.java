package com.example.demo.entities;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
    @Entity
    public class Instrument {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank(message = "Nom obligatoire")
        private String nom;
        private String famille;
        private boolean disponibilite = true;
        public Instrument() {}
        public Instrument(String nom, String famille) {
            this.nom = nom;
            this.famille = famille;
        }

        public Instrument(String nom, boolean disponibilite, String famille) {
            this.nom = nom;
            this.disponibilite = disponibilite;
            this.famille = famille;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public @NotBlank(message = "Nom obligatoire") String getNom() {
            return nom;
        }

        public void setNom(@NotBlank(message = "Nom obligatoire") String nom) {
            this.nom = nom;
        }

        public String getFamille() {
            return famille;
        }

        public void setFamille(String famille) {
            this.famille = famille;
        }

        public boolean isDisponibilite() {
            return disponibilite;
        }

        public void setDisponibilite(boolean disponibilite) {
            this.disponibilite = disponibilite;
        }

// getters & setters
    }
