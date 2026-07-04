package com.tailoringmanagementsystem.DTO;


import lombok.Data;


@Data
public class LoginResponse 
{
    private Long userId;
    private String firstName;
    private String email;
    private String role;
    public LoginResponse() 
    {
    }
    public LoginResponse(Long userId,String firstName,String email,String role)
    {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.role = role;
    }
}