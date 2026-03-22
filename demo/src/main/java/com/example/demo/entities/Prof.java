package com.example.demo.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nom obligatoire")
    private String nom;
    private String specialite;

    public Prof() {}

    public Prof(String nom, String specialite) {
        this.nom = nom;
        this.specialite = specialite;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
// getters & setters
}