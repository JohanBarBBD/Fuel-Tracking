package api.fuelTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            // throw not authorised error
            throw new Exception();
            
        }
    }

    
}
