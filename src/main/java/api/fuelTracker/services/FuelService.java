package api.fuelTracker.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.dto.FuelWithPriceDto;
import api.fuelTracker.exceptions.AlreadyExistsException;
import api.fuelTracker.exceptions.FuelNotFoundException;
import api.fuelTracker.models.Fuel;
import api.fuelTracker.models.FuelPrice;
import api.fuelTracker.repository.FuelPricesRepository;
import api.fuelTracker.repository.FuelsRepository;

@Service
public class FuelService {
    @Autowired
    FuelsRepository fuelsRepository;

    @Autowired
    FuelPricesRepository fuelPricesRepository;

    public Fuel getFuelById(int id) {
        Optional<Fuel> fuel = fuelsRepository.findById(id);
        return fuel.orElseThrow(() -> new FuelNotFoundException("Could not find fuel type with ID: " + id));
    }

    public Fuel getFuelByType(String fuelType) {
        Optional<Fuel> fuel = fuelsRepository.findByFuelType(fuelType);
        return fuel.orElseThrow(() -> new FuelNotFoundException("Could not find a fuel of type: " + fuelType));
    }

    public List<Fuel> getAllFuelTypes() {
        List<Fuel> fuels = fuelsRepository.findAll();

        if (!fuels.isEmpty()) {
            return fuels;
        }

        return Collections.emptyList();
    }

    public FuelWithPriceDto getFuelWithCurrentPrice(int id) {
        Optional<Fuel> fuel = fuelsRepository.findById(id);
        Optional<FuelPrice> fuelPrice = fuelPricesRepository.findTop1ByFuelIdOrderByStartDateDesc(id);

        if (!fuel.isPresent()) {
            throw new FuelNotFoundException("Could not find fuel type with ID: " + id);
        } else if (!fuelPrice.isPresent()) {
            throw new FuelNotFoundException("Could not find any prices for fuel with ID: " + id);
        }

        return new FuelWithPriceDto()
                .setFuelId(id)
                .setFuelType(fuel.get().getFuelType())
                .setCurrentPrice(fuelPrice.get().getPricePerLitre());
    }

    public Fuel addFuelType(Fuel fuel) {
        Optional<Fuel> existingFuel = fuelsRepository.findByFuelType(fuel.getFuelType());
        if (existingFuel.isPresent()) {
            throw new AlreadyExistsException(fuel.getFuelType() + " already exists");
        }

        fuelsRepository.save(fuel);
        return fuel;
    }

    public FuelPrice addFuelPrice(FuelPrice fuelPrice) {
        Optional<Fuel> fuel = fuelsRepository.findById(fuelPrice.getId());
        if (!fuel.isPresent()) {
            throw new FuelNotFoundException("Could not find a fuel: " + fuelPrice.getId());
        }

        fuelPricesRepository.save(fuelPrice);
        return fuelPrice;
    }
}
