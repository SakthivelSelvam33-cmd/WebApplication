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

import com.tailoringmanagementsystem.Entity.Payment;
import com.tailoringmanagementsystem.Service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController 
{
    private final PaymentService service;

    public PaymentController(PaymentService service)
    {
        this.service = service;
    }
    @PostMapping
    public Payment addPayment(@RequestBody Payment payment)
    {
        return service.savePayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments()
    {
        return service.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById( @PathVariable Long id)
    {
        return service.getPaymentById(id);
    }
    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment)
    {
     return service.updatePayment(id, payment);
    }

    @DeleteMapping("/{id}")
    public String deletePayment( @PathVariable Long id )
    {
        service.deletePayment(id);
        return "Payment Deleted Successfully";
    }
}
