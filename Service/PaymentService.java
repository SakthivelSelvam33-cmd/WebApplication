package com.tailoringmanagementsystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tailoringmanagementsystem.Entity.Payment;
import com.tailoringmanagementsystem.Repo.PaymentRepository;

@Service
public class PaymentService 
{
     private final PaymentRepository repository;
    public PaymentService(PaymentRepository repository)
    {
        this.repository = repository;
    }
    public Payment savePayment(Payment payment )
    {
        return repository.save(payment);
    }
    public List<Payment> getAllPayments()
    {
        return repository.findAll();
    }
    public Payment getPaymentById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public Payment updatePayment(Long id,Payment payment)
    {
        Payment oldPayment = repository.findById(id).orElse(null);
        if(oldPayment != null)
        {
            oldPayment.setBookingId( payment.getBookingId());
            oldPayment.setTotalAmount( payment.getTotalAmount());
            oldPayment.setPaidAmount( payment.getPaidAmount());
            oldPayment.setBalanceAmount( payment.getBalanceAmount());
            oldPayment.setPaymentMethod( payment.getPaymentMethod());
            oldPayment.setPaymentStatus( payment.getPaymentStatus());
            oldPayment.setPaymentDate(payment.getPaymentDate());
            return repository.save(oldPayment);
        }
        return null;
    }
    public void deletePayment(Long id)
    {
        repository.deleteById(id);
    }
}
