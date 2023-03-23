package api.fuelTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.exceptions.AlreadyExistsException;
import api.fuelTracker.exceptions.Unauthorised;
import api.fuelTracker.exceptions.VehicleNotFoundException;
import api.fuelTracker.models.Access;
import api.fuelTracker.models.Vehicle;
import api.fuelTracker.repository.AccessRepositry;
import api.fuelTracker.repository.FuelsRepository;
import api.fuelTracker.repository.VehiclesRepository;

@Service
public class VehiclesService {
    @Autowired
    VehiclesRepository vehiclesRepository;
    @Autowired
    AccessRepositry accessRepositry;
    @Autowired
    FuelsRepository fuelsRepository;

    public List<Vehicle> retrieveUserVehicles(String apiKey) {
        List<Access> accessObject = accessRepositry.findByApiKey(apiKey);

        if (!accessObject.isEmpty()) {
            return vehiclesRepository.findByAccessId(accessObject.get(0).getAccessId());
        } else{
            throw new Unauthorised();
        }
    }

    public Vehicle retrieveUserVehicleByRegistrationNumber(String apiKey, String registrationNumber) {
        Access accessObject = (accessRepositry.findByApiKey(apiKey)).get(0) ;

        if (accessObject != null) {
            List<Vehicle> vehicles = vehiclesRepository.findByRegistrationNumber(registrationNumber);

            if (vehicles.isEmpty()) {
                throw new VehicleNotFoundException("Vehicle with registration number "+ registrationNumber + " not found");
            } else {
                return vehicles.get(0);
            }
            
        } else {
            throw new Unauthorised();
        }
    }

    public Vehicle addVehicle(String apiKey, String fuelType, Vehicle newVehicle) {
        Access accessObject = (accessRepositry.findByApiKey(apiKey)).get(0) ;
        if (!vehiclesRepository.findByRegistrationNumber(newVehicle.getRegistrationNumber()).isEmpty()) {
            throw new AlreadyExistsException("Vehicle with registration number "+ newVehicle.getRegistrationNumber()+ " is already added");
        }
        if (accessObject != null) {
            newVehicle.setAccessId(accessObject.getAccessId());
            newVehicle.setFuel(fuelsRepository.findByFuelType(fuelType));
            vehiclesRepository.save(newVehicle);
            return newVehicle;
        } else {
            throw new Unauthorised();
        }
    }

    
}
