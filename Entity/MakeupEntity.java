package com.tailoringmanagementsystem.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="makeup_booking")

public class MakeupEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long customerId;
    private Long serviceId;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String artistName;
    private Double totalAmount;
    private Double advanceAmount;
    private Double balanceAmount;
    private String paymentStatus;
    private String bookingStatus;
    private LocalDate createdDate = LocalDate.now();
    public Long getBookingId() 
    {
    return bookingId;
    }
    public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;

    }
    public Long getCustomerId() {
    return customerId;
    }
    public void setCustomerId(Long customerId) {
    this.customerId = customerId;
    }
    public Long getServiceId() {
    return serviceId;
    }
    public void setServiceId(Long serviceId) {
    this.serviceId = serviceId;
    }
    public LocalDate getBookingDate() {
    return bookingDate;
    }
    public void setBookingDate(LocalDate bookingDate) {
    this.bookingDate = bookingDate;

    }
    public LocalTime getBookingTime() {

    return bookingTime;

    }
    public void setBookingTime(LocalTime bookingTime) {

    this.bookingTime = bookingTime;

    }
    public String getArtistName() {

    return artistName;

    }
    public void setArtistName(String artistName) {

    this.artistName = artistName;

    }
    public Double getTotalAmount() {

    return totalAmount;

    }
    public void setTotalAmount(Double totalAmount) {

    this.totalAmount = totalAmount;

    }
    public Double getAdvanceAmount() {

    return advanceAmount;

    }
    public void setAdvanceAmount(Double advanceAmount) {

    this.advanceAmount = advanceAmount;

    }
    public Double getBalanceAmount() {

    return balanceAmount;

    }
    public void setBalanceAmount(Double balanceAmount) {

    this.balanceAmount = balanceAmount;

    }
    public String getPaymentStatus() {

    return paymentStatus;

    }
    public void setPaymentStatus(String paymentStatus) {

    this.paymentStatus = paymentStatus;

    }
    public String getBookingStatus() {

    return bookingStatus;

    }
    public void setBookingStatus(String bookingStatus) {

    this.bookingStatus = bookingStatus;

    }
    public LocalDate getCreatedDate() {

    return createdDate;

    }
    public void setCreatedDate(LocalDate createdDate) {

    this.createdDate = createdDate;

    }

}
