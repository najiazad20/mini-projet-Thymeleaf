package com.example.demo.entities;
import jakarta.persistence.*;
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jour;
    private String heureDebut;
    private int dureeMin;
    private String niveau;
    @ManyToOne
    private Prof prof;
    public Cours() {}
    public Cours(Prof prof, String niveau, int dureeMin, String heureDebut, String jour) {
        this.prof = prof;
        this.niveau = niveau;
        this.dureeMin = dureeMin;
        this.heureDebut = heureDebut;
        this.jour = jour;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJour() {
        return jour;
    }
    public void setJour(String jour) {
        this.jour = jour;
    }
    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getDureeMin() {
        return dureeMin;
    }

    public void setDureeMin(int dureeMin) {
        this.dureeMin = dureeMin;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }
// getters & setters
}