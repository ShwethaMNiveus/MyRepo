package com.shwetham.SimpleJavaApplication.DTO;


import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import jakarta.annotation.Nonnull;

@Component
public class VehicleDTO {

	private Long id;
	
	@Nonnull
	private String registrationNo;

	@Nonnull
	private String vehicleType;

	private String name;

	private String brand;
	
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "VehicleDTO [id=" + id + ", registrationNo=" + registrationNo + ", vehicleType=" + vehicleType
				+ ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}

	
	
}
