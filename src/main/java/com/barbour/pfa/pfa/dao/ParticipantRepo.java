package com.barbour.pfa.pfa.dao;

import com.barbour.pfa.pfa.models.Compte;
import com.barbour.pfa.pfa.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepo extends JpaRepository<Participant,Long> {
    List<Participant> findByEmailEquals(String email);
}
