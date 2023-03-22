package api.fuelTracker.repository;

import api.fuelTracker.models.FuelPrice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelPricesRepository extends JpaRepository<FuelPrice, Integer> {
}