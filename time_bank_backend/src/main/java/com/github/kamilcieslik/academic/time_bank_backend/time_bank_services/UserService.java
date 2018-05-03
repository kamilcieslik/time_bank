package com.github.kamilcieslik.academic.time_bank_backend.time_bank_services;

import com.github.kamilcieslik.academic.time_bank_backend.entity.User;

public interface UserService extends CRUDService<User> {
    User findByLogin(String login);
    User findByEmail(String email);
    Boolean checkUserExists(String login, String email);
    User findByLoginAndPassword(String login, String password);
}
