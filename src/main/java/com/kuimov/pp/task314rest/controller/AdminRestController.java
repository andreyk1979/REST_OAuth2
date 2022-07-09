package com.kuimov.pp.task314rest.controller;

import com.kuimov.pp.task314rest.models.Role;
import com.kuimov.pp.task314rest.service.RoleService;
import com.kuimov.pp.task314rest.service.UserService;
import com.kuimov.pp.task314rest.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


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


    @GetMapping("/roles")
    public ResponseEntity<Set<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    //Get authenticated User for authenticatedUsers.js
    @GetMapping("/authenticatedUsers")
    public ResponseEntity<User> getAuthenticationUser(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Get a user by Id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserId(@PathVariable long id) throws Exception {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //create user
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/users")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //edit user
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/users")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        User useredit = userService.save(user);
        return new ResponseEntity<>(useredit, HttpStatus.OK);
    }
    //delete User
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUserId(@PathVariable long id) throws Exception {
        User user = userService.getUserById(id);
        userService.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}