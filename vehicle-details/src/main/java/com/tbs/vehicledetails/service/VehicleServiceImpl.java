package com.tbs.vehicledetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tbs.vehicledetails.entity.Vehicle;
import com.tbs.vehicledetails.exception.VehicleNotFoundException;
import com.tbs.vehicledetails.repository.VehicleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public List<Vehicle> findAllVehicles() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle, Long id) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public void deleteVehicle(Long id) {
		vehicleRepository.deleteById(id);
	}

	@Override
	public Vehicle getVehicleById(Long id) throws VehicleNotFoundException {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if(!vehicle.isPresent()) {
			System.out.println("I'm coming");
			throw new VehicleNotFoundException("Vehicle Not Found");
		}
		return vehicle.get();
	}

	@Override
	public List<Vehicle> getVehicleByName(String busName) throws VehicleNotFoundException{
		List<Vehicle> vehicle = vehicleRepository.findAllByBusName(busName);
		if(vehicle.isEmpty()) {
			throw new VehicleNotFoundException("Vehicle by that name not available");
		}
		return vehicle;
	}

	@Override
	public List<Vehicle> getVehicleByAvailabilty() throws VehicleNotFoundException {
		
		Sort sortBySeat = Sort.by(Sort.Direction.DESC,"availableSeatCount");
		
		List<Vehicle> vehicle = vehicleRepository.findAll(sortBySeat);
		List<Vehicle> filtered = new ArrayList<Vehicle>();
		
		if(vehicle.isEmpty()) {
			throw new VehicleNotFoundException("All Bus Full");
		}
		for(Vehicle v : vehicle) {
			if(v.getAvailableSeatCount()>1) {
				filtered.add(v);
			}
		}
		return filtered;
	}

	@Override
	public List<Vehicle> getVehicleByPrice() throws VehicleNotFoundException {
		Sort sortByPrice = Sort.by("price");
		return vehicleRepository.findAll(sortByPrice);
	}
	
	
	
	
}
