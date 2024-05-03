package com.tbs.vehicledetails.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long busId;
	
	private String busName;
	
	private String numberPlate;
	
	private String driverName;
	
	private Integer seatCount;
	
	private Integer availableSeatCount;
	
	private Long price;

	public Vehicle() {
		
	}
	
	public Vehicle(Long busId, String busName, String numberPlate, String driverName, Integer seatCount, Integer availableSeatCount, Long price) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.numberPlate = numberPlate;
		this.driverName = driverName;
		this.seatCount = seatCount;
		this.availableSeatCount = availableSeatCount;
		this.price = price;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Integer getAvailableSeatCount() {
		return availableSeatCount;
	}

	public void setAvailableSeatCount(Integer availableSeatCount) {
		this.availableSeatCount = availableSeatCount;
	}
	
	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [busId=" + busId + ", busName=" + busName + ", numberPlate=" + numberPlate + ", driverName="
				+ driverName + ", seatCount=" + seatCount + ", availableSeatCount=" + availableSeatCount + ", price="
				+ price + "]";
	}
	
	
}
