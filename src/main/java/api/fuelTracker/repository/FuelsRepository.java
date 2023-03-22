package api.fuelTracker.repository;

import api.fuelTracker.models.Fuel;

import org.springframework.data.jpa.repository.JpaRepository;
public interface FuelsRepository extends JpaRepository<Fuel, Integer> {
}
