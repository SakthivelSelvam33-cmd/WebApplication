package com.tailoringmanagementsystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tailoringmanagementsystem.Entity.MakeupCustomer;
import com.tailoringmanagementsystem.Repo.MakeupCustomerRepository;

@Service
public class MakeupCustomerService 
{
    private final MakeupCustomerRepository repository;
    public MakeupCustomerService(MakeupCustomerRepository repository)
    {
        this.repository = repository;
    }
    public MakeupCustomer saveCustomer(MakeupCustomer customer)
    {
        return repository.save(customer);
    }
    public List<MakeupCustomer> getAllCustomers()
    {
        return repository.findAll();
    }
    public MakeupCustomer getCustomerById(Long id)
    {
        return repository.findById(id).orElse(null);
    }
    public MakeupCustomer updateCustomer( Long id,MakeupCustomer customer)
    {
        MakeupCustomer oldCustomer =repository.findById(id).orElse(null);
        if(oldCustomer != null)
        {
            oldCustomer.setCustomerName(customer.getCustomerName() );
            oldCustomer.setPhone(customer.getPhone());
            oldCustomer.setEmail(customer.getEmail());
            oldCustomer.setAddress(customer.getAddress());
            return repository.save(oldCustomer);
        }
        return null;
    }

    public void deleteCustomer(Long id)
    {
        repository.deleteById(id);
    }

}
