package com.barbour.pfa.pfa.dao;

import com.barbour.pfa.pfa.models.Compte;
import com.barbour.pfa.pfa.models.Depense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepenseRepo extends JpaRepository<Depense,Long> {
}
