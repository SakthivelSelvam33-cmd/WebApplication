package com.tailoringmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailoringmanagementsystem.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
