package com.greenfoxacademy.redditprojekt.redditprojekt.Services;

import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.Model.User;
import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private User currentUser;

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser (User user){
        currentUser = userRepository.save(user);
    }

    public User getCurrentUser(){
        return currentUser;
    }
}
