package api.fuelTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.exceptions.AlreadyExistsException;
import api.fuelTracker.exceptions.Unauthorised;
import api.fuelTracker.models.Access;
import api.fuelTracker.models.Vehicle;
import api.fuelTracker.repository.AccessRepositry;
import api.fuelTracker.repository.VehiclesRepository;

@Service
public class VehiclesService {
    @Autowired
    VehiclesRepository vehiclesRepository;
    @Autowired
    AccessRepositry accessRepositry;

    public List<Vehicle> retrieveUserVehicles(Access access) throws Exception{
        Access accessObject = accessRepositry.getReferenceById(access.getAccessId());

        if (accessObject != null) {
            // List<Vehicle> vehicles =
            return vehiclesRepository.findByAccessId(access.getAccessId());
        } else{
            throw new Unauthorised("Unauthorised access!");
        }
    }

    public List<Vehicle> retrieveUserVehicleByRegistrationNumber(String apiKey, String registrationNumber) {
        Access accessObject = (accessRepositry.findByApiKey(apiKey)).get(0) ;

        if (accessObject != null) {
            return vehiclesRepository.findByRegistrationNumber(registrationNumber);
        } else {
            throw new Unauthorised("Unauthorised access!");
        }
    }

    public void addVehicle(String apiKey, Vehicle newVehicle) {
        Access accessObject = (accessRepositry.findByApiKey(apiKey)).get(0) ;
        if (!vehiclesRepository.findByRegistrationNumber(newVehicle.getRegistrationNumber()).isEmpty()) {
            throw new AlreadyExistsException("Vehicle with registration number "+ newVehicle.getRegistrationNumber()+ " is already added");
        }
        if (accessObject != null) {
            vehiclesRepository.save(newVehicle);
        } else {
            throw new Unauthorised("Unauthorised access!");
        }
    }

    
}
