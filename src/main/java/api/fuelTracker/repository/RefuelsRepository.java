package api.fuelTracker.repository;

import api.fuelTracker.models.Refuel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RefuelsRepository extends JpaRepository<Refuel, Integer> {
    List<Refuel> findByVehicleId(int vehicle_Id);
}
