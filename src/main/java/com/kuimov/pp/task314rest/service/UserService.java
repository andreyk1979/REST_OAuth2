package com.kuimov.pp.task314rest.service;

import com.kuimov.pp.task314rest.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void save(User user);

    void delete(User user);

    void edit(User user);

    User getUserById(long id);

    User getUserByEmail (String email);

}
