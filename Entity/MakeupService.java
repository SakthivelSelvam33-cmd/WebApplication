package com.tailoringmanagementsystem.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="makeup_service")
public class MakeupService 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    private String serviceName;
    private String description;
    private Double price;
    private LocalDate createdDate = LocalDate.now();

    public Long getServiceId() {

        return serviceId;

    }
    public void setServiceId(Long serviceId) {

        this.serviceId = serviceId;

    }
    public String getServiceName() {

        return serviceName;

    }
    public void setServiceName(String serviceName) {

        this.serviceName = serviceName;

    }
    public String getDescription() {

        return description;

    }
    public void setDescription(String description) {

        this.description = description;

    }
    public Double getPrice() {

        return price;

    }
    public void setPrice(Double price) {

        this.price = price;

    }
    public LocalDate getCreatedDate() {

        return createdDate;

    }
    public void setCreatedDate(LocalDate createdDate) {

        this.createdDate = createdDate;

    }

}
