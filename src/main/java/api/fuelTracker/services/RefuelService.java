package api.fuelTracker.services;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.exceptions.RefuelsNotFoundException;
import api.fuelTracker.exceptions.Unauthorised;
import api.fuelTracker.models.Refuel;
import api.fuelTracker.models.Vehicle;
import api.fuelTracker.repository.AccessRepositry;
import api.fuelTracker.repository.RefuelsRepository;

@Service
public class RefuelService {
    @Autowired
    RefuelsRepository refuelsRepository;
    @Autowired
    AccessRepositry accessRepositry;
    @Autowired
    VehiclesService vehiclesService;

    public float getTotalRefuelsOfUser(String apiKey) {
        if (accessRepositry.findByApiKey(apiKey).isEmpty()) {
            throw new Unauthorised();
        } else {
            return refuelsRepository.getTotalRefuels(apiKey);
        }
    }

    public List<Refuel> getRefuelsByVehicleRegNumber(String apiKey, String registrationNumber) {
        Vehicle vehicle = vehiclesService.retrieveUserVehicleByRegistrationNumber(apiKey, registrationNumber);
        List<Refuel> refuels = refuelsRepository.findByVehicleId(vehicle.getId());

        if (refuels.isEmpty()) {
            throw new RefuelsNotFoundException("Refuel data for vehicle with registration number "+ registrationNumber + " is not found.");
        } else {
            return refuels;
        }
    }

    public List<Refuel> getRefuelsByDate(String apiKey, Date refuelDate) {
        if (accessRepositry.findByApiKey(apiKey).isEmpty()) {
            throw new Unauthorised();
        } else {
            return refuelsRepository.findByRefuelDate(refuelDate);
        }
    }

    public Refuel addRefuel(String apiKey, String registrationNumber, Refuel newRefuel) {
        Vehicle vehicle = vehiclesService.retrieveUserVehicleByRegistrationNumber(apiKey, registrationNumber);
        
        newRefuel.setVehicleId(vehicle.getId());
        refuelsRepository.save(newRefuel);
        return newRefuel;
    }

}
