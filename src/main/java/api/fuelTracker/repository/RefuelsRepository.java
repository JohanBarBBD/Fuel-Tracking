package api.fuelTracker.repository;

import api.fuelTracker.models.Refuel;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RefuelsRepository extends JpaRepository<Refuel, Integer> {
    List<Refuel> findByVehicleId(int vehicle_Id);
    List<Refuel> findByRefuelDate(Date refuelDate);

    @Query(value = "SELECT SUM(cost) FROM Refuels r INNER JOIN Vehicles v ON r.vehicle_id=v.vehicle_id INNER JOIN Access a ON a.access_id=v.access_id AND a.api_key = :apiKey", nativeQuery = true )
    float getTotalRefuels(@Param("apiKey") String apiKey);
}
