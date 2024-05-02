package com.tbs.vehicledetails.service;

import java.util.List;

import com.tbs.vehicledetails.entity.Vehicle;
import com.tbs.vehicledetails.exception.VehicleNotFoundException;

public interface VehicleService {
	
	List<Vehicle> findAllVehicles();

	Vehicle addVehicle(Vehicle vehicle);
	
	Vehicle updateVehicle(Vehicle vehicle, Long id);
	
	void deleteVehicle(Long id);
	
	Vehicle getVehicleById(Long id) throws VehicleNotFoundException;
	
	List<Vehicle> getVehicleByName(String busName) throws VehicleNotFoundException;
	
	List<Vehicle> getVehicleByAvailabilty() throws VehicleNotFoundException;
	
	List<Vehicle> getVehicleByPrice() throws VehicleNotFoundException;
	
	
	
}
