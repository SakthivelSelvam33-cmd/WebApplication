package com.tailoringmanagementsystem.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="measurement")
public class Measurement 
{
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long measurementId;
    private Long orderId;
    private Double chest;
    private Double waist;
    private Double shoulder;
    private Double sleeve;
    private Double hip;
    private Double neck;
    private Double length;
    private LocalDate createdDate = LocalDate.now();

    public Long getMeasurementId() {
        return measurementId;
    }
    public void setMeasurementId(Long measurementId) {
        this.measurementId = measurementId;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Double getChest() {
        return chest;
    }
    public void setChest(Double chest) {
        this.chest = chest;
    }
    public Double getWaist() {
        return waist;
    }
    public void setWaist(Double waist) {
        this.waist = waist;
    }
    public Double getShoulder() {
        return shoulder;
    }
    public void setShoulder(Double shoulder) {
        this.shoulder = shoulder;
    }
    public Double getSleeve() {
        return sleeve;
    }
    public void setSleeve(Double sleeve) {
        this.sleeve = sleeve;
    }
    public Double getHip() {
        return hip;
    }
    public void setHip(Double hip) {
        this.hip = hip;
    }
    public Double getNeck() {
        return neck;
    }
    public void setNeck(Double neck) {
        this.neck = neck;
    }
    public Double getLength() {
        return length;
    }
    public void setLength(Double length) {
        this.length = length;
    }
    public LocalDate getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
