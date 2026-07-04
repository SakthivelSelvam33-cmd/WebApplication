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

import com.tailoringmanagementsystem.Entity.MakeupService;
import com.tailoringmanagementsystem.Service.MakeupServiceService;

@RestController
@RequestMapping("/api/makeup-services")
@CrossOrigin("*")
public class MakeupServiceController 
{
    private final MakeupServiceService service;
    public MakeupServiceController( MakeupServiceService service)
    {
        this.service = service;
    }
    @PostMapping
    public MakeupService addService( @RequestBody MakeupService makeupService)
    {
        return service.saveService(makeupService);
    }
    @GetMapping
    public List<MakeupService> getAllServices()
    {
        return service.getAllServices();
    }
    @GetMapping("/{id}")

    public MakeupService getOneService( @PathVariable Long id)
    {
        return service.getServiceById(id);
    }
    @PutMapping("/{id}")
    public MakeupService updateService( @PathVariable Long id,@RequestBody MakeupService makeupService)
    {
        return service.updateService(id, makeupService);
    }
    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Long id)
    {
        service.deleteService(id);
        return "Makeup Service Deleted Successfully";
    }
}
