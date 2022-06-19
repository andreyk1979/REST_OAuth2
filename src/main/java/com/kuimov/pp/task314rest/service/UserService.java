package com.kuimov.pp.task314rest.service;

import com.kuimov.pp.task314rest.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User save(User user);

    void delete(User user);

    void edit(User user);

    User getUserById(long id);

    User getUserByEmail (String email);

    User getAuthenticationUser(User user);

}
