package com.kuimov.pp.task314rest.service;

import com.kuimov.pp.task314rest.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User save(User user);

    void delete(User user);

    void edit(User user);

    User getUserById(long id) throws Exception;

    User getUserByEmail (String email);

}
