package api.fuelTracker.repository;

import api.fuelTracker.models.Refuel;
import org.springframework.data.repository.CrudRepository;

public interface RefuelsRepository extends CrudRepository<Refuel, Integer> {

}
