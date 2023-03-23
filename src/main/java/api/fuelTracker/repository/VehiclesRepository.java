package api.fuelTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.fuelTracker.models.Vehicle;

public interface VehiclesRepository extends JpaRepository<Vehicle, Integer> {
}
