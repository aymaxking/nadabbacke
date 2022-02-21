package com.barbour.pfa.pfa.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String login;
    private String password;

    @OneToMany
    private List<Compte> types = new ArrayList<Compte>();
}
