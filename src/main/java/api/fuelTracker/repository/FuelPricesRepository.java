package api.fuelTracker.repository;

import api.fuelTracker.models.FuelPrice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelPricesRepository extends JpaRepository<FuelPrice, Integer> {
    Optional<FuelPrice> findFirstByIdOrderByStartDateDesc(int id);
}