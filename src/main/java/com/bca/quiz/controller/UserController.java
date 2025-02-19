package com.bca.quiz.controller;

import com.bca.quiz.model.User;
import com.bca.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
}
