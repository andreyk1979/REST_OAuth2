package com.kuimov.pp.task314rest.controller;


import com.kuimov.pp.task314rest.dto.UserDTO;
import com.kuimov.pp.task314rest.service.RoleService;
import com.kuimov.pp.task314rest.service.RoleServiceImp;
import com.kuimov.pp.task314rest.service.UserService;
import com.kuimov.pp.task314rest.service.UserServiceImp;
import com.kuimov.pp.task314rest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}