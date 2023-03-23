package api.fuelTracker.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.fuelTracker.dto.responses.Response;
import api.fuelTracker.models.Fuel;
import api.fuelTracker.services.FuelService;

@RestController
@RequestMapping("/fuel")
@Api(value = "", description = "Details about fuels types and fuel prices")
public class FuelController {
    @Autowired
    private FuelService fuelService;

    @GetMapping("/fuelType/{id}")
    public Response getFuelType(@PathVariable int id) {
        return Response
                .ok()
                .setPayload(fuelService.getFuelType(id));
    }

    @GetMapping("/allFuelTypes")
    public Response getAllFuelTypes() {
        return Response
                .ok()
                .setPayload(fuelService.getAllFuelTypes());
    }

    // @GetMapping("/currentFuelPrice")
    // public Response getCurrentFuelPrice() {
    // return Response
    // .ok()
    // .setPayload(fuelService.getCurrentFuelPrice());
    // }

    // @GetMapping("/futureFuelPrice")

    @PostMapping(value = "/createFuel", consumes = "application/json", produces = "application/json")
    public Response createFuelType(@RequestBody Fuel fuel) {
        return Response
                .ok()
                .setPayload(fuelService.createFuelType(fuel));
    }

}
