package com.kuimov.pp.task314rest.service;

import com.kuimov.pp.task314rest.models.User;
import com.kuimov.pp.task314rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// «Пользователь» – это просто Object. В большинстве случаев он может быть
//  приведен к классу UserDetails.
// Для создания UserDetails используется интерфейс UserDetailsService, с единственным методом "loadUserByUsername":

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(useremail);
        if (user == null) throw new UsernameNotFoundException("Нет такого " + useremail);
        return user;
    }
}
