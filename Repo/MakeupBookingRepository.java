package com.tailoringmanagementsystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailoringmanagementsystem.Entity.MakeupEntity;

public interface MakeupBookingRepository extends JpaRepository<MakeupEntity, Long> {

}
