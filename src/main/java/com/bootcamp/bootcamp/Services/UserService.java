package com.bootcamp.bootcamp.Services;

import com.bootcamp.bootcamp.Models.User;
import com.bootcamp.bootcamp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

@Autowired
    private UserRepository userRepository;

    public void saveUser (User user){
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        List<User> usersList = userRepository.findAll();
        return usersList;
    }

}
