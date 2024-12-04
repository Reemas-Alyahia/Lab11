package com.example.lab11.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor


@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty(message = "username must not be Empty!...")
    @Size(min = 4, message = "The length must be more than 4 characters")
    @Column(columnDefinition ="varchar(10) not null unique")
    private String username;

    public String getPassword() {
        return password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    ///Pattern for pass
    @NotEmpty(message = "password cannot be Empty!..")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;


    @NotEmpty(message = "email cannot be Empty!..")
    @Email(message = "Must be a valid email format")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;


    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate registrationDate = LocalDate.now();


    public User(Integer userId, String username, String password, String email, LocalDate registrationDate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public User() {

    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
