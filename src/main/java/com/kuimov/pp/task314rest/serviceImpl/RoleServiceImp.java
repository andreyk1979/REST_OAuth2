package com.kuimov.pp.task314rest.serviceImpl;

import com.kuimov.pp.task314rest.models.Role;
import com.kuimov.pp.task314rest.repository.RoleRepository;
import com.kuimov.pp.task314rest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Set<Role> getSetRoles(Set<String> roles) {
        return roleRepository.findAllByNameIn(roles);
    }

}