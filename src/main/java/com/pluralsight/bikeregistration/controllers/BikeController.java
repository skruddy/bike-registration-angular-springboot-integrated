package com.pluralsight.bikeregistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.bikeregistration.models.Bike;
import com.pluralsight.bikeregistration.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {
	
	@Autowired
	private BikeRepository bikeRepository;
	
	@GetMapping
	public List<Bike> list(){
		return bikeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") Long id) {
		return bikeRepository.findById(id).orElse(new Bike());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Bike bike) {
		bikeRepository.saveAndFlush(bike);
	}

}
