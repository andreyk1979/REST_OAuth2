package com.kuimov.pp.task314rest.service;

import com.kuimov.pp.task314rest.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User save(User user) throws Exception;

    void delete(User user);

    User edit(User user) throws Exception;

    User getUserById(long id) throws Exception;

    User getUserByEmail(String email);

}
