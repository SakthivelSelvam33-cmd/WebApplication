package com.tailoringmanagementsystem.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignUpRequest 
{
     @NotBlank(message = "First name required")
    private String firstName;
    @NotBlank(message = "Last name required")
    private String lastName;
    @NotBlank(message = "Email required")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Phone required")
    @Pattern(
        regexp = "^[0-9]{10}$",
        message = "Phone number must contain 10 digits"
    )
    private String phone;

    @NotBlank(message = "Password required")
    private String password;
    @NotBlank(message = "Confirm password required")
    private String confirmPassword;
    private String city;
    private String state;
    private String address;
    private String companyName;
}
