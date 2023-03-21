package api.fuelTracker.repository;

import api.fuelTracker.models.Fuel;
import org.springframework.data.repository.CrudRepository;

public interface FuelsRepository extends CrudRepository<Fuel, Integer> {
}
