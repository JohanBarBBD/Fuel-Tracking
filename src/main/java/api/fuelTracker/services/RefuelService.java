package api.fuelTracker.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.exceptions.FuelNotFoundException;
import api.fuelTracker.models.Access;
import api.fuelTracker.models.Refuel;
import api.fuelTracker.repository.AccessRepositry;
import api.fuelTracker.repository.RefuelsRepository;

@Service
public class RefuelService {
    @Autowired
    RefuelsRepository refuelsRepository;
    @Autowired
    AccessRepositry accessRepositry;

    public Refuel getRefuel(int Id) {
        Optional<Refuel> refuel = refuelsRepository.findById(Id);
        return refuel.orElseThrow(() -> new FuelNotFoundException("Could not find refuel with ID: " + Id));
    }

    public List<Refuel> getAllRefuels() {
        List<Refuel> refuels = refuelsRepository.findAll();

        if (!refuels.isEmpty()) {
            return refuels;
        }

        return Collections.emptyList();
    }

    public List<Refuel> getRefuelsByVehicleId(int id) {
        List<Refuel> refuels = (List<Refuel>) refuelsRepository.findByVehicleId(id);

        if (!refuels.isEmpty()) {
            return refuels;
        }

        return Collections.emptyList();
    }

    public List<Refuel> getRefuelsByDate(int id) {
        List<Refuel> refuels = (List<Refuel>) refuelsRepository.findByVehicleId(id);

        if (!refuels.isEmpty()) {
            return refuels;
        }

        return Collections.emptyList();
    }

    public Refuel createRefuel(Refuel refuel) {
        refuelsRepository.save(refuel);

        return refuel;
    }

    public Refuel addRefuel(String apiKey, Refuel newRefuel) {
        Access accessObject = (accessRepositry.findByApiKey(apiKey)).get(0) ;        
        if (accessObject != null) {
            newRefuel.setAccessId(accessObject.getAccessId());;
            refuelsRepository.save(newRefuel);
            return newRefuel;
        } else {
            throw new Unauthorised("Unauthorised access!");
        }
    }

}
