package api.fuelTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.fuelTracker.models.Vehicle;
import api.fuelTracker.repository.VehiclesRepository;
import api.fuelTracker.services.VehiclesService;

@RestController
@RequestMapping("api/v1/")
public class VehiclesController {
    @Autowired
    private VehiclesService vehiclesService;

    // @GetMapping
    // public List<Vehicle> getAllVehicles() {
    // return vehiclesRepository.findAll();
    // }

    // @PostMapping
    // public Vehicle createVehicle(@RequestBody Vehicles vehicle) {
    // return vehiclesRepository.save(vehicle);
    // }

}
