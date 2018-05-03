package com.github.kamilcieslik.academic.time_bank_backend.database.service;

import com.github.kamilcieslik.academic.time_bank_backend.entity.User;
import com.github.kamilcieslik.academic.time_bank_backend.database.repository.UserRepository;
import com.github.kamilcieslik.academic.time_bank_backend.time_bank_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("database")
public class UserDbServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserDbServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public User find(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean checkUserExists(String login, String email) {
        return userRepository.findByLogin(login) != null || userRepository.findByEmail(email) != null;
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }
}
