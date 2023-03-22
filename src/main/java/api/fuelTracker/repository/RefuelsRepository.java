package api.fuelTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.fuelTracker.models.Refuel;
public interface RefuelsRepository extends JpaRepository<Refuel, Integer> {

}
