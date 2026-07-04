package com.tailoringmanagementsystem.Service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tailoringmanagementsystem.DTO.LoginRequest;
import com.tailoringmanagementsystem.DTO.LoginResponse;
import com.tailoringmanagementsystem.DTO.SignUpRequest;
import com.tailoringmanagementsystem.Entity.User;
import com.tailoringmanagementsystem.Repo.UserRepository;

import lombok.RequiredArgsConstructor;
import com.tailoringmanagementsystem.Entity.PasswordReset;
import com.tailoringmanagementsystem.Repo.PasswordResetRepository;

import java.time.LocalDateTime;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class UserService 
{
        private final UserRepository userRepository2;
        private final PasswordEncoder passwordEncoder2;
        private final EmailService emailService2;
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final EmailService emailService;
        private final PasswordResetRepository passwordResetRepository;
    public User saveUser(SignUpRequest request)
    {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        if(userRepository.existsByPhone(request.getPhone()))
        {
            throw new RuntimeException("Phone number already exists");
        }
        if(!request.getPassword().equals(request.getConfirmPassword()))
        {
            throw new RuntimeException( "Password and Confirm Password not match");
        }
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword( passwordEncoder.encode( request.getPassword()));
       user.setConfirmPassword(passwordEncoder.encode(request.getConfirmPassword()));
        user.setCity( request.getCity());
        user.setState(request.getState());
        user.setAddress(request.getAddress());
        user.setCompanyName( request.getCompanyName());
        user.setRole("ADMIN");



        // Save Database

        User savedUser =userRepository.save(user);

        // Email sending
        try 
        {
           emailService.sendSignupMail(savedUser);
        } catch(Exception e)
        {
            System.out.println("Mail sending failed : "+ e.getMessage());
        }
        return savedUser;
    }
   public LoginResponse login(LoginRequest request)
   {
    User user =userRepository.findByEmail(request.getEmail()).orElseThrow(() ->new RuntimeException("User not found") );
    if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
        throw new RuntimeException("Invalid Password");
    }
    return new LoginResponse(user.getUserId(),user.getFirstName(),user.getEmail(),user.getRole() );


}

//===================send OTP==========================

public String sendOtp(String email)
{
    User user =userRepository.findByEmail(email).orElseThrow(() ->new RuntimeException("Email not found"));
    String otp =String.valueOf(new Random().nextInt(900000)+ 100000);
    PasswordReset reset =new PasswordReset();
    reset.setEmail(email);
    reset.setOtp(otp);
    reset.setExpiryTime(LocalDateTime.now().plusMinutes(10));
    passwordResetRepository.save(reset);
    emailService.sendEmail(email,"Password Reset OTP","Your OTP is : " + otp);
    return "OTP Sent Successfully";
}



public String verifyOtp( String email,String otp)
{
        PasswordReset reset =passwordResetRepository.findByEmail(email).orElseThrow(() ->new RuntimeException( "OTP not found"));
        if(!reset.getOtp().equals(otp))
        {
                throw new RuntimeException("Invalid OTP");
        }
         if(reset.getExpiryTime().isBefore(LocalDateTime.now()))
        {
                throw new RuntimeException( "OTP Expired");

        }
        return "OTP Verified";
}

public String resetPassword(String email, String password) 
{
        if(email == null || email.isEmpty())
        {
                throw new RuntimeException("Email is missing");
        }

        User user = userRepository.findByEmail(email).orElseThrow(() ->new RuntimeException("User not found: " + email));
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        passwordResetRepository.deleteByEmail(email);
        return "Password Updated Successfully";
}
}