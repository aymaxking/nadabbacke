package com.barbour.pfa.pfa.models;

import lombok.Data;

import javax.mail.Part;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Compte {
    @Id
    @GeneratedValue
    private Long id;
    private String titre;
    private String description;
    private  Long adminid;
    private double budget;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Participant> participants = new ArrayList<Participant>();

    public void addparticipant(Participant participant) {
        if (participants == null) participants = new ArrayList<Participant>();
        participants.add(participant);
    }
}
