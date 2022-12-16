package com.shwetham.simplejavaapplication.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "vehicle")
public class VehicleEntity implements java.io.Serializable{

	@Id
	@Column(name = "id")
	 @GeneratedValue(generator = "Vehicle_SequenceStyleGenerator")
	 @GenericGenerator(name = "Vehicle_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	 parameters = {
	 @Parameter(name = "sequence_name", value = "Vehicle_SEQ"),
	 @Parameter(name="optimizer", value="hilo"),
	 @Parameter(name = "initial_value", value = "4"),
	 @Parameter(name = "increment_size", value = "1") }
	 )
	private Integer id;
	
	@Column(name = "registration_no")
	private String registrationNo;
	
	@Column(name = "vehicle_type")
	private String vehicleType;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "price")
	private Double price;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "VehicleEntiry [id=" + id + ", registrationNo=" + registrationNo + ", vehicleType=" + vehicleType
				+ ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
	
	
}
