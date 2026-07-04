package com.tailoringmanagementsystem.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tailoringmanagementsystem.DTO.LoginRequest;
import com.tailoringmanagementsystem.DTO.LoginResponse;
import com.tailoringmanagementsystem.DTO.SignUpRequest;
import com.tailoringmanagementsystem.Entity.User;
import com.tailoringmanagementsystem.Service.UserService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.tailoringmanagementsystem.DTO.ForgotPasswordRequest;
import com.tailoringmanagementsystem.DTO.VerifyOtpRequest;
import com.tailoringmanagementsystem.DTO.ResetPasswordRequest;



@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://127.0.0.1:5500","http://localhost:5500"})
public class UserController 
{
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpRequest request )
    {
        try {
            User user =userService.saveUser(request);
            return ResponseEntity.ok(user);
        } 
        catch(Exception e)
        {
            return ResponseEntity.badRequest() .body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login( @RequestBody LoginRequest request )
    {
        try 
        {
            LoginResponse response = userService.login(request);
            return ResponseEntity.ok(response);

        } 
        catch(Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest request)
    {
    try
    {
        String result = userService.sendOtp( request.getEmail());
        return ResponseEntity.ok(result);
    }
    catch(Exception e)
    {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody VerifyOtpRequest request){
    try
    {
        return ResponseEntity.ok(userService.verifyOtp(request.getEmail(),request.getOtp()));
    }
    catch(Exception e)
    {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) 
    {
    System.out.println("EMAIL: " + request.getEmail());
    System.out.println("PASSWORD: " + request.getPassword());
    try 
    {
        String result = userService.resetPassword(request.getEmail(),request.getPassword());
        return ResponseEntity.ok(result);

    } 
    catch(Exception e) 
    {
        e.printStackTrace(); 
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

}