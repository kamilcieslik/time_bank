package com.github.kamilcieslik.academic.time_bank_backend.memory;

import com.github.kamilcieslik.academic.time_bank_backend.TimeBankApplication;
import com.github.kamilcieslik.academic.time_bank_backend.entity.User;
import com.github.kamilcieslik.academic.time_bank_backend.time_bank_services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Qualifier("memory")
public class UserMemoryServiceImpl implements UserService {
    @Override
    public User findByLogin(String login) {
        return TimeBankApplication.databaseInMemory.findUserByLogin(login);
    }

    @Override
    public User findByEmail(String email) {
        return TimeBankApplication.databaseInMemory.findUserByEmail(email);
    }

    @Override
    public Boolean checkUserExists(String login, String email) {
        return TimeBankApplication.databaseInMemory.findUserByLogin(login) != null
                || TimeBankApplication.databaseInMemory.findUserByEmail(email) != null;
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return TimeBankApplication.databaseInMemory.findUserByLoginAndPassword(login, password);
    }

    @Override
    public List<User> findAll() {
        return TimeBankApplication.databaseInMemory.getUsers();
    }

    @Override
    public User save(User entity) {
        List<User> users = TimeBankApplication.databaseInMemory.getUsers();
        if (users==null || users.size()==0)
            entity.setId(1);
        else{
            User userWithTheBiggestId = users.stream().max(Comparator.comparing(User::getId)).get();
            entity.setId(userWithTheBiggestId.getId()+1);
        }

        TimeBankApplication.databaseInMemory.addUser(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        TimeBankApplication.databaseInMemory.deleteUser(TimeBankApplication.databaseInMemory.findUserById(id));
    }

    @Override
    public void delete(User entity) {
        TimeBankApplication.databaseInMemory.deleteUser(entity);
    }

    @Override
    public User find(Integer id) {
        return TimeBankApplication.databaseInMemory.findUserById(id);
    }
}
