package com.pluralsight.bikeregistration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluralsight.bikeregistration.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long>{

}
