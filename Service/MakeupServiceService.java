package com.tailoringmanagementsystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tailoringmanagementsystem.Entity.MakeupService;
import com.tailoringmanagementsystem.Repo.MakeupServiceRepository;

@Service
public class MakeupServiceService 
{
     private final MakeupServiceRepository repository;
    public MakeupServiceService(MakeupServiceRepository repository)
    {
        this.repository = repository;
    }
    public MakeupService saveService(MakeupService service)
    {
        return repository.save(service);
    }
    public List<MakeupService> getAllServices()
    {
        return repository.findAll();
    }
    public MakeupService getServiceById(Long id )
    {
        return repository.findById(id).orElse(null);
    }

    public MakeupService updateService(Long id, MakeupService serviceData)
    {
        MakeupService oldService =repository.findById(id).orElse(null);
        if(oldService != null)
        {
            oldService.setServiceName(serviceData.getServiceName());
            oldService.setDescription(serviceData.getDescription());
            oldService.setPrice(serviceData.getPrice());
            return repository.save(oldService);
        }
        return null;
    }

    public void deleteService(Long id)
    {
        repository.deleteById(id);
    }
}
