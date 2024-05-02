package com.tbs.vehicledetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbs.vehicledetails.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	public List<Vehicle> findAllByBusName(String busName);
	
//	public List<Vehicle> findAllByAvailableSeatCount(Integer availableSeatCount);

	
}
