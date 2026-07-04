package com.tailoringmanagementsystem.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class MakeupBookingDTO 
{
    private Long bookingId;
    private String customerName;
    private String serviceName;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String artistName;
    private Double totalAmount;
    private Double advanceAmount;
    private Double balanceAmount;
    private String paymentStatus;
    private String bookingStatus;
    public Long getBookingId() {
    return bookingId;
    }
    public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
    }
    public String getCustomerName() {
    return customerName;
    }
    public void setCustomerName(String customerName) {
    this.customerName = customerName;
    }

    public String getServiceName() {
    return serviceName;
    }
    public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
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

}
