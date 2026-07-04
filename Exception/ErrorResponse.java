package com.tailoringmanagementsystem.Exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse 
{
    private String message;
    private int status;
    private LocalDateTime time;
    public ErrorResponse(String message,int status)
    {
        this.message = message;
        this.status = status;
        this.time = LocalDateTime.now();
    }



}
