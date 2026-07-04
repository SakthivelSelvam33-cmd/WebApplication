package com.tailoringmanagementsystem.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tailoringmanagementsystem.DTO.MakeupBookingDTO;
import com.tailoringmanagementsystem.Entity.MakeupEntity;
import com.tailoringmanagementsystem.Service.MakeupBookingService;

@RestController

@RequestMapping("/api/makeup-bookings")

@CrossOrigin("*")
public class MakeupBookingController 
{
     private final MakeupBookingService service;
     public MakeupBookingController(MakeupBookingService service)
     {
        this.service = service;
    }

    @PostMapping
    public MakeupEntity addBooking( @RequestBody MakeupEntity booking)
    {
        return service.saveBooking(booking);
    }
    @GetMapping
    public List<MakeupEntity> viewBookings()
    {
        return service.getAllBookings();
    }
    @GetMapping("/{id}")
    public MakeupEntity getBooking( @PathVariable Long id)
    {
        return service.getBookingById(id);
    }
    @PutMapping("/{id}")
    public MakeupEntity updateBooking( @PathVariable Long id, @RequestBody MakeupEntity booking)
    {
        return service.updateBooking(id, booking);
    }
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id)
    {
        service.deleteBooking(id);
        return "Booking Deleted Successfully";
    }
    @GetMapping("/details")
    public List<MakeupBookingDTO> viewDetails()
    {
    return service.getBookingDetails();
    }
}
