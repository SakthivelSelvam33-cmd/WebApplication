package com.tailoringmanagementsystem.DTO;

import lombok.Data;

@Data
public class VerifyOtpRequest 
{
    private String email;
    private String otp;

}
