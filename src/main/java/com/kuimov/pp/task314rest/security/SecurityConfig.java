package com.kuimov.pp.task314rest.security;

import com.kuimov.pp.task314rest.service.RoleService;
import com.kuimov.pp.task314rest.service.UserDetailsServiceImpl;
import com.kuimov.pp.task314rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService; // используется только для Создание админа в БД
    private final RoleService roleService; // используется только для Создание админа в БД

    private final SuccessUserHandler successUserHandler; // класс, в котором описана логика перенаправления пользователей по ролям

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public SecurityConfig(UserService userService, RoleService roleService, SuccessUserHandler successUserHandler, UserDetailsServiceImpl userDetailsService) {
        this.userService = userService;
        this.roleService = roleService;
        this.successUserHandler = successUserHandler;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { //для аутентификации
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { //для авторизации
        http
                .authorizeRequests()

                .antMatchers("/user", "/login", "/webjars/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/admin/**", "/api/admin/**", "/users").hasAuthority("ADMIN")
                .and()
                .formLogin().loginPage("/login").permitAll().successHandler(successUserHandler)
                .and().httpBasic()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .and()
                .csrf().disable()
                .cors().disable();

/* для автоматического создания админа (включать только после создания таблицы через create)
    @PostConstruct
    private void postConstruct() {
        User admin = new User("Andrey", "Kuimov", 43, "kuimow@mail.ru", "123456", roleService.getAllRoles());
        userService.save(admin);
    }*/
    }
}