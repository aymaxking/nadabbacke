package com.barbour.pfa.pfa.dao;

import com.barbour.pfa.pfa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByLoginEqualsAndPasswordEquals(String login , String password);
}
