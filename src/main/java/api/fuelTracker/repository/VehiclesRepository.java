package api.fuelTracker.repository;

import org.springframework.data.repository.CrudRepository;
import api.fuelTracker.models.Vehicle;

public interface VehiclesRepository extends CrudRepository<Vehicle, Integer> {
}
