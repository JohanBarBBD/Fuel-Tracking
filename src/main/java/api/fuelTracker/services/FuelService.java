package api.fuelTracker.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.models.Fuel;
import api.fuelTracker.repository.FuelsRepository;

@Service
public class FuelService {
    FuelsRepository fuelsRepository;

    // public Fuel getFuelType(int Id) {
    // Optional<Fuel> fuel = fuelsRepository.findById(Id);

    // if (fuel.isPresent()) {
    // return fuel.get();
    // }
    // throw exception();
    // }

    // @GetMapping("/fuelType")
    // public Response getFuelType() {
    // return Response
    // .ok()
    // .setPayload();
    // }

    // @GetMapping("/allFuelTypes")

    // @GetMapping("/currentFuelPrice")

    // @GetMapping("/futureFuelPrice")
}
