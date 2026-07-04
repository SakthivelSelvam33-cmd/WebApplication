package com.tailoringmanagementsystem.Service;


import java.util.List;

import org.springframework.stereotype.Service;


import com.tailoringmanagementsystem.Entity.MakeupEntity;
import com.tailoringmanagementsystem.DTO.MakeupBookingDTO;
import com.tailoringmanagementsystem.Repo.MakeupBookingRepository;
import com.tailoringmanagementsystem.Repo.MakeupCustomerRepository;
import com.tailoringmanagementsystem.Repo.MakeupServiceRepository;
@Service
public class MakeupBookingService 
{
    private final MakeupBookingRepository repository;
    private final MakeupCustomerRepository customerRepo;
    private final MakeupServiceRepository serviceRepo;
    public MakeupBookingService(MakeupBookingRepository repository,MakeupCustomerRepository customerRepo,MakeupServiceRepository serviceRepo)
    {
        this.repository = repository;
        this.customerRepo = customerRepo;
        this.serviceRepo = serviceRepo;
    }

    public MakeupEntity saveBooking( MakeupEntity booking)
    {
        return repository.save(booking);
    }

    public List<MakeupEntity> getAllBookings()
    {
        return repository.findAll();
    }

    public MakeupEntity getBookingById(Long id)
    {
        return repository.findById(id).orElse(null);
    }
    public MakeupEntity updateBooking(Long id,MakeupEntity booking)
    {
        MakeupEntity old =repository.findById(id).orElse(null);
        if(old != null){
            old.setCustomerId(booking.getCustomerId());
            old.setServiceId(booking.getServiceId());
            old.setBookingDate(booking.getBookingDate());
            old.setBookingTime(booking.getBookingTime());
            old.setArtistName(booking.getArtistName());
            old.setTotalAmount(booking.getTotalAmount());
            old.setAdvanceAmount(booking.getAdvanceAmount());
            old.setBalanceAmount( booking.getBalanceAmount());
            old.setPaymentStatus(booking.getPaymentStatus());
            old.setBookingStatus(booking.getBookingStatus());
            return repository.save(old);
        }
        return null;
    }

    public void deleteBooking(Long id)
    {
        repository.deleteById(id);


    }

    public List<MakeupBookingDTO> getBookingDetails(){

        List<MakeupEntity> list =repository.findAll();
        return list.stream().map(b -> {
            MakeupBookingDTO dto = new MakeupBookingDTO();
            dto.setBookingId( b.getBookingId());
            dto.setCustomerName(customerRepo.findById( b.getCustomerId() ).get().getCustomerName() );
            dto.setServiceName(serviceRepo.findById( b.getServiceId() ).get() .getServiceName());
            dto.setBookingDate(b.getBookingDate());
            dto.setBookingTime(b.getBookingTime() );
            dto.setArtistName( b.getArtistName() );
            dto.setTotalAmount(b.getTotalAmount() );
            dto.setAdvanceAmount(b.getAdvanceAmount() );
            dto.setBalanceAmount(b.getBalanceAmount() );
            dto.setPaymentStatus( b.getPaymentStatus());
            dto.setBookingStatus( b.getBookingStatus());
            return dto;
        }).toList();



    }



}