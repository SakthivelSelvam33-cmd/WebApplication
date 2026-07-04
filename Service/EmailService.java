package com.tailoringmanagementsystem.Service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tailoringmanagementsystem.Entity.User;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmailService 
{
    private final JavaMailSender mailSender;
    public void sendSignupMail(User user)
    {
        SimpleMailMessage message =new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Account Created Successfully");
        message.setText( "Hi " + user.getFirstName()+ ",\n\n"
                + "Your Tailoring Management account created successfully.\n\n"
                + "User ID : "
                + user.getUserId()
                + "\n\n"
                + "Name : "
                + user.getFirstName()
                + " "
                + user.getLastName()
                + "\n\n"
                + "Company Name : "
                + user.getCompanyName()
                + "\n\n"
                + "Role : "
                + user.getRole()
                + "\n\n"
                + "Phone Number : "
                + user.getPhone()
                + "\n\n"
                + "Email : "
                + user.getEmail()
                + "\n\n"
                + "Thank You."

        );
        mailSender.send(message);
    }

    public void sendEmail(String email,String subject,String body)
    {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setSubject(subject);
    message.setText(body);
    mailSender.send(message);
}
}