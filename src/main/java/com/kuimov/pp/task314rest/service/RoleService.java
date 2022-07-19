package com.kuimov.pp.task314rest.service;

import com.kuimov.pp.task314rest.models.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RoleService {

    Set<Role> getAllRoles();

    void add(Role role);

    Set<Role> getSetRoles(Set<String> roles);

}
