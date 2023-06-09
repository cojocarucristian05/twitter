package com.ligaaclabs.twitter.model.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public UserRegisterDTO(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
