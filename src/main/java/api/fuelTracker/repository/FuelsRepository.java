package api.fuelTracker.repository;

import api.fuelTracker.models.Fuel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelsRepository extends JpaRepository<Fuel, Integer> {
    Optional<Fuel> findByFuelType(String fuel_type);
}
