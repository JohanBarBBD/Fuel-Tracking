package api.fuelTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.fuelTracker.models.Vehicle;

public interface VehiclesRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByAccessId(Integer accessId);
    List<Vehicle> findByRegistrationNumber(String registrationNumber);
    
}
