package com.shwetham.SimpleJavaApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shwetham.SimpleJavaApplication.Entities.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer>{

}
