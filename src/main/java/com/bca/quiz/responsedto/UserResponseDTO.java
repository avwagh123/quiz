package com.bca.quiz.responsedto;

import com.bca.quiz.model.Role;
import com.bca.quiz.model.User;
import java.sql.Timestamp;
import java.util.Set;

public class UserResponseDTO {
    private Integer userId;
    private String email;
    private String password;
    private Timestamp createdAt;
    private Set<Role> roles;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public UserResponseDTO() {

    }

    public UserResponseDTO(String email, String password, Timestamp createdAt, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.createdAt = createdAt;
    }

    public UserResponseDTO(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.createdAt = user.getCreatedAt();
    }


}
