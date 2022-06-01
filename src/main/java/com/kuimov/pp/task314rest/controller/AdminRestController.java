package com.kuimov.pp.task314rest.controller;

import com.kuimov.pp.task314rest.service.RoleService;
import com.kuimov.pp.task314rest.service.UserService;
import com.kuimov.pp.task314rest.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    //Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Getting a user by Id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserId(@PathVariable long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //создание пользователя
    @PostMapping("/users")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //изменения пользователя
    @PutMapping("/users")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        User useredit = userService.save(user);
        return new ResponseEntity<>(useredit, HttpStatus.OK);
    }
    //удалние пользователя
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUserId(@PathVariable long id) {
        User user = userService.getUserById(id);
        userService.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}