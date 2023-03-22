package api.fuelTracker.repository;

import api.fuelTracker.models.Record;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepository extends JpaRepository<Record, Integer> {

}
