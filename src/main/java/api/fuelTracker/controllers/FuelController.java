package api.fuelTracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.fuelTracker.dto.responses.Response;
import api.fuelTracker.models.Fuel;
import api.fuelTracker.models.FuelPrice;
import api.fuelTracker.services.FuelService;

@RestController
@RequestMapping("/fuel")
public class FuelController {
    @Autowired
    private FuelService fuelService;

    @GetMapping("/fuelById/{id}")
    public Response<?> getFuelType(@PathVariable int id) {
        return Response
                .ok()
                .setPayload(fuelService.getFuelById(id));
    }

    @GetMapping("/fuelByType/{fuelType}")
    public Response<?> getFuelType(@PathVariable String fuelType) {
        return Response
                .ok()
                .setPayload(fuelService.getFuelByType(fuelType));
    }

    @GetMapping("/allFuels")
    public Response<?> getAllFuelTypes() {
        return Response
                .ok()
                .setPayload(fuelService.getAllFuelTypes());
    }

    @GetMapping("/fuelWithCurrentPrice/{id}")
    public Response<?> getFuelWithCurrentPrice(@PathVariable int id) {
        return Response
                .ok()
                .setPayload(fuelService.getFuelWithCurrentPrice(id));
    }

    @PostMapping(value = "/addFuel", consumes = "application/json", produces = "application/json")
    public Response<?> addFuelType(@RequestBody Fuel fuel) {
        return Response
                .ok()
                .setPayload(fuelService.addFuelType(fuel));
    }

    @PostMapping(value = "/addFuelPrice", consumes = "application/json", produces = "application/json")
    public Response<?> addFuelPrice(@RequestBody FuelPrice fuelPrice) {
        return Response
                .ok()
                .setPayload(fuelService.addFuelPrice(fuelPrice));
    }

}
