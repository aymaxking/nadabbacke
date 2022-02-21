package com.barbour.pfa.pfa.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private  String telephone;
    private Double depenses;

    public Participant(String nom, String prenom, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }
}
