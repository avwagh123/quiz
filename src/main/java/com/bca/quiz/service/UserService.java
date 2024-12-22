package com.bca.quiz.service;

import com.bca.quiz.dao.UserRepository;
import com.bca.quiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long userId){
        return userRepository.findById(userId);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void deleteById(Long userId){
        userRepository.deleteById(userId);
    }
}
