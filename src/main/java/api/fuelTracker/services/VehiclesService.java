package api.fuelTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.exceptions.AlreadyExistsException;
import api.fuelTracker.exceptions.FuelNotFoundException;
import api.fuelTracker.exceptions.InvalidDataException;
import api.fuelTracker.exceptions.Unauthorised;
import api.fuelTracker.exceptions.VehicleNotFoundException;
import api.fuelTracker.models.Access;
import api.fuelTracker.models.Fuel;
import api.fuelTracker.models.FuelPrice;
import api.fuelTracker.models.Vehicle;
import api.fuelTracker.repository.AccessRepositry;
import api.fuelTracker.repository.FuelPricesRepository;
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
    @Autowired
    FuelPricesRepository fuelPricesRepository;

    public List<Vehicle> retrieveUserVehicles(String apiKey) {
        List<Access> accessObject = accessRepositry.findByApiKey(apiKey);

        if (!accessObject.isEmpty()) {
            List<Vehicle> vehicles = vehiclesRepository.findByAccessId(accessObject.get(0).getAccessId());
            return vehicles;
        } else{
            throw new Unauthorised();
        }
    }

    public Vehicle retrieveUserVehicleByRegistrationNumber(String apiKey, String registrationNumber) {
        Access accessObject = (accessRepositry.findByApiKey(apiKey)).get(0);

        if (accessObject != null) {
            List<Vehicle> vehicles = vehiclesRepository.findByRegistrationNumber(registrationNumber);

            if (vehicles.isEmpty()) {
                throw new VehicleNotFoundException(
                        "Vehicle with registration number " + registrationNumber + " not found");
            } else {
                return vehicles.get(0);
            }

        } else {
            throw new Unauthorised();
        }
    }

    public Vehicle addVehicle(String apiKey, String fuelType, Vehicle newVehicle) {
        Access accessObject = (accessRepositry.findByApiKey(apiKey)).get(0);
        Optional<Fuel> fuel = fuelsRepository.findByFuelType(fuelType);
        if (!vehiclesRepository.findByRegistrationNumber(newVehicle.getRegistrationNumber()).isEmpty()) {
            throw new AlreadyExistsException(
                    "Vehicle with registration number " + newVehicle.getRegistrationNumber() + " is already added");
        } else if (!fuel.isPresent()) {
            throw new FuelNotFoundException("Could not find a fuel of type: " + fuelType);
        } else if (accessObject != null) {
            newVehicle.setAccessId(accessObject.getAccessId());
            newVehicle.setFuel(fuel.get());
            vehiclesRepository.save(newVehicle);
            return newVehicle;
        } else {
            throw new Unauthorised();
        }
    }

    public float estimateFuelCost(String apiKey, String registrationNumber, float distanceToTravel) {
        Access accessObject = (accessRepositry.findByApiKey(apiKey)).get(0);
        float calculatedCost = 0;

        if (distanceToTravel < 0) {
            throw new InvalidDataException("distanceToTravel");
        } else if (accessObject != null) {
            Vehicle vehicle = retrieveUserVehicleByRegistrationNumber(apiKey, registrationNumber);
            FuelPrice fuelPrice = fuelPricesRepository.findFirstByIdOrderByStartDateDesc(vehicle.getFuel().getId())
                    .get();

            calculatedCost = (distanceToTravel / (vehicle.getKmPerLitre() * fuelPrice.getPricePerLitre()));
        } else {
            throw new Unauthorised();
        }
        return calculatedCost;
    }

}
