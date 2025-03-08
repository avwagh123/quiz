package com.bca.quiz.requestdto;

import com.bca.quiz.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class UserRequestDTO {
    @Email(message = "Invalid Email format")
    private String email;
    @Size(min = 7, message = "Password should be at least 7 characters long")
    private String password;
    private Set<Role> roles;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public UserRequestDTO(){}

    public UserRequestDTO(String email, String password, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
