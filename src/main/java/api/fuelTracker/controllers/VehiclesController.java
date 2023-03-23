package api.fuelTracker.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.fuelTracker.dto.responses.Response;
import api.fuelTracker.models.Vehicle;
import api.fuelTracker.services.VehiclesService;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    @Autowired
    private VehiclesService vehiclesService;

    // @GetMapping
    // public List<Vehicle> getAllVehicles() {
    // return vehiclesRepository.findAll();
    // }
    @PostMapping (value = "/userVehicles")
    Response getUserVehicles(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(vehiclesService.retrieveUserVehicles(object.get("apiKey")));
    }

    @PostMapping (value = "/vehicleByRegNumber")
    Response getVehicleByRegNumber(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(vehiclesService.retrieveUserVehicleByRegistrationNumber(object.get("apiKey"),
                        object.get("registrationNumber")));
    }

    @PostMapping (value = "/new")
    public Response createVehicle(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(vehiclesService.addVehicle(object.get("apiKey"), object.get("fuelType"),
                        createVehicleObject(object)));
    }

    private Vehicle createVehicleObject(Map<String, String> object) {
        return new Vehicle()
                .setKmPerLitre(Float.parseFloat(object.get("kmPerLitre")))
                .setMake(object.get("make"))
                .setRegistrationNumber(object.get("registrationNumber"))
                .setOdometerReading(Float.parseFloat(object.get("odometerReading")))
                .setTankSize(Float.parseFloat(object.get("tankSize")))
                .setModel(object.get("model"));

    }

}
