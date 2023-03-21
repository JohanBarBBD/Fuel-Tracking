package api.fuelTracker.repository;

import api.fuelTracker.models.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordsRepository extends CrudRepository<Record, Integer> {

}
