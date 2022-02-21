package com.barbour.pfa.pfa.dao;

import com.barbour.pfa.pfa.models.Compte;
import com.barbour.pfa.pfa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte,Long> {
}
