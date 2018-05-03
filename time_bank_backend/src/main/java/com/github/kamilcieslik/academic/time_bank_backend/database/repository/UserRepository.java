package com.github.kamilcieslik.academic.time_bank_backend.database.repository;

import com.github.kamilcieslik.academic.time_bank_backend.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
    User findByEmail(String email);
    User findByLoginAndPassword(String login, String password);
}
