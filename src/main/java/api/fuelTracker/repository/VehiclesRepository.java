package api.fuelTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.fuelTracker.models.Vehicles;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Integer> {
    
}
