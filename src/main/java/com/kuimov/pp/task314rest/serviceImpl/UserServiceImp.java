package com.kuimov.pp.task314rest.serviceImpl;
//user.setPassword(passwordEncoder.encode(user.getPassword()));
// userRepository.saveAndFlush(user); для save

import com.kuimov.pp.task314rest.models.User;
import com.kuimov.pp.task314rest.repository.UserRepository;
import com.kuimov.pp.task314rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Transactional
    public User save(User user) throws Exception {
        if (user.getId() != null) {
            if (user.getPassword().equals(getUserById(user.getId()).getPassword())) {
                userRepository.save(user);
            }
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user;
        }
        userRepository.saveAndFlush(user);
        return user;
    }
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }
    @Transactional
    public User edit(User user) throws Exception {

        if (!user.getPassword().equals(getUserById(user.getId()).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        save(user);
        return user;
    }

    @Transactional(readOnly = true)
    public User getUserById(long id) throws Exception {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new Exception("Юзер с id " + id + " не найден");
        }
        return user;
    }
    @Transactional
    @Override
    public User getUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", email));
        }
        return user;
    }
}