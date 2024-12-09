package org.example.englishlessonspring.service;


import org.example.englishlessonspring.model.entity.User;
import org.example.englishlessonspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User save(User user) {
       User userSaved = userRepository.save(user);
       return userSaved;
    }

    public User findById(long id) {
       return userRepository.findById(id).orElse(null);
    }




}
