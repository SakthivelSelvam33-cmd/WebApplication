package com.tailoringmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailoringmanagementsystem.Entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement,Long>{

}
