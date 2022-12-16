package com.shwetham.simplejavaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shwetham.simplejavaapplication.entities.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer>{

}
