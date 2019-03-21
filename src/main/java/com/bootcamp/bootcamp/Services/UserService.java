package com.bootcamp.bootcamp.Services;

import com.bootcamp.bootcamp.Models.CourseEdition;
import com.bootcamp.bootcamp.Models.Role;
import com.bootcamp.bootcamp.Models.User;
import com.bootcamp.bootcamp.Repository.RoleRepository;
import com.bootcamp.bootcamp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

@Autowired
    private UserRepository userRepository;
@Autowired
    private RoleRepository roleRepository;
@Autowired
    private RoleService roleService;

    public void saveUser (User user){

        //tutaj muszę ustawić rolę i hasło! dwie kolejne linijki - kodowanie hasła.
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = roleService.getRole("user");

        user.setRole(role);

        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        List<User> usersList = userRepository.findAll();
        return usersList;
    }



//kodowanie hasła - za pomocą password encoder!
//PaswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
}
