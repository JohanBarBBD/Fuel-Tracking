package api.fuelTracker.repository;

import api.fuelTracker.models.Refuel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RefuelsRepository extends JpaRepository<Refuel, Integer> {

}
