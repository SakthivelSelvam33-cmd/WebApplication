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

import com.tailoringmanagementsystem.Entity.MakeupCustomer;
import com.tailoringmanagementsystem.Service.MakeupCustomerService;

@RestController
@RequestMapping("/api/makeup-customers")
@CrossOrigin("*")
public class MakeupCustomerController 
{
     private final MakeupCustomerService service;
    public MakeupCustomerController(MakeupCustomerService service)
    {
        this.service = service;
    }
    @PostMapping
    public MakeupCustomer addCustomer(@RequestBody MakeupCustomer customer)
    {
        return service.saveCustomer(customer);
    }
    @GetMapping
    public List<MakeupCustomer> getAllCustomers()
    {
        return service.getAllCustomers();
    }
    @GetMapping("/{id}")
    public MakeupCustomer getCustomerById( @PathVariable Long id)
    {
        return service.getCustomerById(id);
    }
    @PutMapping("/{id}")
    public MakeupCustomer updateCustomer( @PathVariable Long id,@RequestBody MakeupCustomer customer)
    {
        return service.updateCustomer(id, customer);
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer( @PathVariable Long id)
    {
        service.deleteCustomer(id);
        return "Customer Deleted Successfully";
    }



}
