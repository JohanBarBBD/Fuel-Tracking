package api.fuelTracker.repository;

import api.fuelTracker.models.FuelPrice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuelPricesRepository extends JpaRepository<FuelPrice, Integer> {
    @Query(value = "select top (1) fp.fuel_price_id,fp.end_date,fp.fuel_id,fp.price_per_litre,fp.start_date from FuelPrices fp where fp.fuel_id=:id order by fp.start_date desc", nativeQuery = true)
    Optional<FuelPrice> findTop1ByFuelIdOrderByStartDateDesc(@Param("id") int id);

    
}