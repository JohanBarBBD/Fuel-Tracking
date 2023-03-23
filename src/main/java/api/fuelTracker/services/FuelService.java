package api.fuelTracker.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.exceptions.FuelNotFoundException;
import api.fuelTracker.models.Fuel;
import api.fuelTracker.repository.FuelsRepository;

@Service
public class FuelService {
    @Autowired
    FuelsRepository fuelsRepository;

    public Fuel getFuelType(int Id) {
        Optional<Fuel> fuel = fuelsRepository.findById(Id);
        return fuel.orElseThrow(() -> new FuelNotFoundException("Could not find specified fuel type"));
    }
}
