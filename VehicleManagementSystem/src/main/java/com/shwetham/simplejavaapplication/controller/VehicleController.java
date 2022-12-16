package com.shwetham.simplejavaapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shwetham.simplejavaapplication.dto.VehicleDTO;
import com.shwetham.simplejavaapplication.entities.VehicleEntity;
import com.shwetham.simplejavaapplication.repository.VehicleRepository;

@RestController
@RequestMapping("/VehicleSystem")
public class VehicleController {
	
	@Autowired
	VehicleRepository vehicleRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@PostMapping("/create")
	public String addVehicle(@RequestBody VehicleDTO vehicle) {
		String message ="";
		try {
			System.out.println("vehicle input: "+vehicle);
			VehicleEntity obj =mapper.map(vehicle, VehicleEntity.class) ;
			System.out.println("after mapper obj: "+obj);
			vehicleRepo.save(obj);
			message ="Vehicle data created Successfully";
			
		}catch(Exception e) {
			message ="create error "+e;
		}
		return message;
	}
	
	@PutMapping("/update")
	public String updateVehicle(@RequestBody VehicleDTO vehicle) {
		String message ="";
		try {
			VehicleEntity obj =mapper.map(vehicle, VehicleEntity.class) ;
			vehicleRepo.save(obj);
			message ="Vehicle data updated Successfully";
			
		}catch(Exception e) {
			message ="update error "+e;
		}
		return message;
	}
	
	@GetMapping("/get")
	public List<VehicleDTO> getAllVehicle() {
		List<VehicleDTO> lstVehicle = new ArrayList<>();
		
		try {
			List<VehicleEntity> lstVehicleEntity = vehicleRepo.findAll();
			for(VehicleEntity obj : lstVehicleEntity ) {
				lstVehicle.add(mapper.map(obj, VehicleDTO.class));
			
			}
			
		}catch(Exception e) {
			System.err.println("get error "+e);
		}
		return lstVehicle;
	}
	
	@DeleteMapping("/delete")
	public String deleteVehicle(@RequestParam("id") Integer id) {
		String message ="";
		
		try {
			VehicleEntity obj = vehicleRepo.findById(id).get();
			vehicleRepo.delete(obj);
			message ="Vehicle data deleted Successfully";
			
		}catch(Exception e) {
			message ="delete error "+e;
		}
		return message;
	}
	
	

}
