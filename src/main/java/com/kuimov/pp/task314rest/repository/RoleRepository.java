package com.kuimov.pp.task314rest.repository;

import com.kuimov.pp.task314rest.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Set<Role> findAllByNameIn(Set<String> roles);
    Role findByName(String role);
}
