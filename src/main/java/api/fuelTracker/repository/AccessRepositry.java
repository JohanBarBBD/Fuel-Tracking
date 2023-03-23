package api.fuelTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.fuelTracker.models.Access;

public interface AccessRepositry extends JpaRepository<Access, Integer> {
    
}
