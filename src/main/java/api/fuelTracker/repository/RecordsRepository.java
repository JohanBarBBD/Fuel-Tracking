package api.fuelTracker.repository;

import api.fuelTracker.models.Record;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepository extends JpaRepository<Record, Integer> {
    List<Record> findByVehicleId(int vehicleId);
}
