package api.fuelTracker.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.exceptions.AlreadyExistsException;
import api.fuelTracker.exceptions.FuelNotFoundException;
import api.fuelTracker.models.Fuel;
import api.fuelTracker.repository.FuelPricesRepository;
import api.fuelTracker.repository.FuelsRepository;

@Service
public class FuelService {
    @Autowired
    FuelsRepository fuelsRepository;

    @Autowired
    FuelPricesRepository fuelPricesRepository;

    public Fuel getFuelType(int Id) {
        Optional<Fuel> fuel = fuelsRepository.findById(Id);
        return fuel.orElseThrow(() -> new FuelNotFoundException("Could not find fuel type with ID: " + Id));
    }

    public List<Fuel> getAllFuelTypes() {
        List<Fuel> fuels = fuelsRepository.findAll();

        if (!fuels.isEmpty()) {
            return fuels;
        }

        return Collections.emptyList();
    }

    public Fuel createFuelType(Fuel fuel) {
        Optional<Fuel> existingFuel = Optional.ofNullable(fuelsRepository.findByFuelType(fuel.getFuelType()));
        if (existingFuel.isPresent()) {
            throw new AlreadyExistsException(fuel.getFuelType() + " already exists");
        }

        fuelsRepository.save(fuel);
        return fuel;
    }

    // public FuelPrice updateFuelPrice(@RequestBody FuelPrice fuelPrice) {

    // }

}
