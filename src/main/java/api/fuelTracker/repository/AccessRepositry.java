package api.fuelTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.fuelTracker.models.Access;

public interface AccessRepositry extends JpaRepository<Access, Integer> {
    @Query(value = "SELECT access_id, email, api_key, validity_until FROM Access a WHERE a.api_key = :apiKey", nativeQuery = true)
    List<Access> findByApiKey(@Param("apiKey") String apiKey);

    @Query(value = "SELECT access_id, email, api_key, validity_until FROM Access a WHERE a.email = :email", nativeQuery = true)
    List<Access> findByEmail(@Param("email") String email);
}
