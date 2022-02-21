package com.barbour.pfa.pfa.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Depense {
    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private double montant;
    @OneToOne
    private Participant participant;
    @OneToOne
    private Compte compte;
    private Long idparticipant;
    private Long idcompte;

}
