package com.bootcamp.bootcamp.Repository;

import com.bootcamp.bootcamp.Models.Role;
import com.bootcamp.bootcamp.Models.Trainers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}
