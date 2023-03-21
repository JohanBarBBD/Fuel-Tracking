package api.fuelTracker.repository;

import api.fuelTracker.models.FuelPrice;
import org.springframework.data.repository.CrudRepository;

public interface FuelPricesRepository extends CrudRepository<FuelPrice, Integer> {
}