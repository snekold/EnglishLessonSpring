package org.example.englishlessonspring.service;


import lombok.AllArgsConstructor;
import org.example.englishlessonspring.model.entity.User;
import org.example.englishlessonspring.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;


    public User save(User user) {
       User userSaved = userRepository.save(user);
       return userSaved;
    }


    public User findById(long id) {
       return userRepository.findById(id).orElse(null);
    }




}
