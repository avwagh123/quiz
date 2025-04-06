package com.bca.quiz.service;

import com.bca.quiz.dao.UserRepository;
import com.bca.quiz.model.User;
import com.bca.quiz.requestdto.UserRequestDTO;
import com.bca.quiz.responsedto.UserResponseDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> findAll(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<UserResponseDTO> findById(Long userId){
        return Optional.ofNullable(userRepository.findById(userId)
                .map(UserResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId)));
    }

    public UserResponseDTO save(UserRequestDTO userRequestDTO){
        User requestUser = new User(userRequestDTO, passwordEncoder);
        User user = userRepository.save(requestUser);
        return new UserResponseDTO(user);
    }

    public void deleteById(Long userId){
        userRepository.deleteById(userId);
    }

    public Integer findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.get().getUserId();
    }
}
