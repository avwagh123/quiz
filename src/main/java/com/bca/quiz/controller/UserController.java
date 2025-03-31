package com.bca.quiz.controller;

import com.bca.quiz.requestdto.UserRequestDTO;
import com.bca.quiz.responsedto.UserResponseDTO;
import com.bca.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserResponseDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserResponseDTO> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    public UserResponseDTO save(@RequestBody UserRequestDTO userRequestDTO){
        return userService.save(userRequestDTO);
    }

    @PutMapping
    public UserResponseDTO update(@RequestBody UserRequestDTO userRequestDTO){
        return userService.save(userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
}
