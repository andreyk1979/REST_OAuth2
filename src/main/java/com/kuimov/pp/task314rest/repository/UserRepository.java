package com.kuimov.pp.task314rest.repository;

import com.kuimov.pp.task314rest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
}
