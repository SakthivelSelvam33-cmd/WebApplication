package com.tailoringmanagementsystem.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String password;
    private String confirmPassword;
    private String role = "ADMIN";
    private String city;
    private String state;
    @Column(columnDefinition = "TEXT")
    private String address;
    private String companyName;
    private String profileImage;
    private LocalDateTime createdDate;
    @PrePersist
    public void createdDate(){

        this.createdDate = LocalDateTime.now();

    }
}
