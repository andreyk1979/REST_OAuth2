package com.kuimov.pp.task314rest.service;

import com.kuimov.pp.task314rest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }


    // для создания UserDetails используется нтерфейс UserDetailsService, c единственным методом:
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String user_email) {
        User user = userService.getUserByEmail(user_email);
        return user;
    }
}
