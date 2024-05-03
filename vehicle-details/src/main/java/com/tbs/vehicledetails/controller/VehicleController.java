package com.tbs.vehicledetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbs.vehicledetails.entity.Vehicle;
import com.tbs.vehicledetails.exception.VehicleNotFoundException;
import com.tbs.vehicledetails.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService service;
	
	@GetMapping("/allVehicles")
	public List<Vehicle> getAllVehicles(){
		return service.findAllVehicles();
	}
	
	@PostMapping("/addVehicle")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		service.addVehicle(vehicle);
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
	}
	
	@PutMapping("{id}")
	public Vehicle updateVehicle(@PathVariable("id") Long vehicleId, @RequestBody Vehicle vehicle) {
		return service.updateVehicle(vehicle, vehicleId);
	}
	
	@GetMapping("{id}")
	public Vehicle findVehicleById(@PathVariable("id")Long vehicleId) throws VehicleNotFoundException {
		return service.getVehicleById(vehicleId);
	}
	
	@GetMapping("name/{vehicleName}")
	public List<Vehicle> findVehicleByName(@PathVariable("vehicleName") String vehicleName)throws VehicleNotFoundException{
		return service.getVehicleByName(vehicleName);
		
	}
	
	@GetMapping("availability")
	public List<Vehicle> findVehicleByAvailability() throws VehicleNotFoundException{
		return service.getVehicleByAvailabilty();
	}
	
	@GetMapping("price")
	public List<Vehicle> findByPrice() throws VehicleNotFoundException{
		return service.getVehicleByPrice();
	}
}
