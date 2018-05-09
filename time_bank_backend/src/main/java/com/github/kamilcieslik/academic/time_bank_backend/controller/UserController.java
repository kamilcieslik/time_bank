package com.github.kamilcieslik.academic.time_bank_backend.controller;

import com.github.kamilcieslik.academic.time_bank_backend.TimeBankApplication;
import com.github.kamilcieslik.academic.time_bank_backend.entity.User;
import com.github.kamilcieslik.academic.time_bank_backend.time_bank_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(@Qualifier(TimeBankApplication.READ_WRITE_MODE) UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "find/{id}", produces = {APPLICATION_JSON_VALUE})
    public User user(@PathVariable Integer id) {
        return userService.find(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login", produces = {APPLICATION_JSON_VALUE})
    public User userByLoginAndPassword(@RequestParam("login") String login, @RequestParam("password") String password) {
        return userService.findByLoginAndPassword(login, password);
    }

    // Użytkownicy (GET):
    @RequestMapping(method = RequestMethod.GET, value = "/findAll", produces = {APPLICATION_JSON_VALUE})
    public Iterable<User> user() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/check", produces = {APPLICATION_JSON_VALUE})
    public boolean checkIfExist(@RequestParam("login") String login, @RequestParam("email") String email) {
        return userService.checkUserExists(login, email);
    }

    // Użytkownicy (POST):
    @RequestMapping(method = RequestMethod.POST, value = "/save", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    // Użytkownicy (PUT):
    @RequestMapping(method ={RequestMethod.PUT}, value = "/update/{id}", produces = {APPLICATION_JSON_VALUE})
    public User update(@PathVariable Integer id, @RequestBody User updatedUser) {
        User user = userService.find(id);

        if (updatedUser.getFirstName() != null)
            user.setFirstName(updatedUser.getFirstName());
        if (updatedUser.getLastName() != null)
            user.setLastName(updatedUser.getLastName());
        if (updatedUser.getPhone() != null)
            user.setPhone(updatedUser.getPhone());
        if (updatedUser.getEmail() != null)
            user.setEmail(updatedUser.getEmail());
        if (updatedUser.getLogin() != null)
            user.setLogin(updatedUser.getLogin());
        if (updatedUser.getPassword() != null)
            user.setPassword(updatedUser.getPassword());

        userService.save(user);
        return updatedUser;
    }

    // Użytkownicy (DELETE):
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE}, value = "/delete/{id}",
            produces = {APPLICATION_JSON_VALUE})
    public void delete(@PathVariable Integer id) {
        User user = userService.find(id);
        userService.delete(user);
    }
}
