package api.fuelTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.fuelTracker.models.Vehicles;
import api.fuelTracker.repository.VehiclesRepository;

@RestController
@RequestMapping("api/v1/")
public class VehiclesController {
    @Autowired
    private VehiclesRepository vehiclesRepository;

    @GetMapping
    public List<Vehicles> getAllVehicles() {
        return vehiclesRepository.findAll();
    }
    
    @PostMapping
    public Vehicles createVehicle(@RequestBody Vehicles vehicle) {
        return vehiclesRepository.save(vehicle);
    }


}
