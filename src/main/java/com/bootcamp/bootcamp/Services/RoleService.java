package com.bootcamp.bootcamp.Services;

import com.bootcamp.bootcamp.Models.Role;
import com.bootcamp.bootcamp.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role getRole(String role){
        return roleRepository.findByRole(role);
    }

    public List<Role> getAllRoles(){
        List<Role> roleList = roleRepository.findAll();
        return roleList;
    }

}
