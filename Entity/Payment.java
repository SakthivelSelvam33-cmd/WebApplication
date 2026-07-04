package com.tailoringmanagementsystem.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Long bookingId;
    private Double totalAmount;
    private Double paidAmount;
    private Double balanceAmount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDate paymentDate = LocalDate.now();
    public Long getPaymentId() {

    return paymentId;

    }
    public void setPaymentId(Long paymentId) {

    this.paymentId = paymentId;

    }

    public Long getBookingId() {

    return bookingId;

    }
    public void setBookingId(Long bookingId) {

    this.bookingId = bookingId;

    }
    public Double getTotalAmount() {

    return totalAmount;

    }
    public void setTotalAmount(Double totalAmount) {

    this.totalAmount = totalAmount;

    }
    public Double getPaidAmount() {

    return paidAmount;

    }
    public void setPaidAmount(Double paidAmount) {

    this.paidAmount = paidAmount;

    }
    public Double getBalanceAmount() {

    return balanceAmount;

    }
    public void setBalanceAmount(Double balanceAmount) {

    this.balanceAmount = balanceAmount;

    }
    public String getPaymentMethod() {

    return paymentMethod;

    }
    public void setPaymentMethod(String paymentMethod) {

    this.paymentMethod = paymentMethod;

    }
    public String getPaymentStatus() {

    return paymentStatus;

    }
    public void setPaymentStatus(String paymentStatus) {

    this.paymentStatus = paymentStatus;

    }
    public LocalDate getPaymentDate() {

    return paymentDate;

    }
    public void setPaymentDate(LocalDate paymentDate) {
    this.paymentDate = paymentDate;
    }
}
