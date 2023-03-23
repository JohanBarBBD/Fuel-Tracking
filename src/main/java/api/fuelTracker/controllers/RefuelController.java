package api.fuelTracker.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.fuelTracker.dto.responses.Response;
import api.fuelTracker.models.Refuel;
import api.fuelTracker.services.RefuelService;

@RestController
@RequestMapping("/refuel")
@Api(value = "", description = "Details about fuels types and fuel prices")
public class RefuelController {
    @Autowired
    private RefuelService refuelService;

    @GetMapping("/")
    public Response getAllRefuels() {
        return Response
                .ok()
                .setPayload(refuelService.getAllRefuels());
    }

    @GetMapping("/refuelsByVehicleID/{id}")
    public Response getRefuelByVehicleID(@PathVariable int id){
        return Response
                .ok()
                .setPayload(refuelService.getRefuelsByVehicleId(id));
    }


    //Post
    @PostMapping(value = "/createFuel", consumes = "application/json", produces = "application/json")
    public Response createFuelType(@RequestBody Refuel refuel) {
        return Response
                .ok()
                .setPayload(refuelService.createRefuel(refuel));
    }

    //delete
}
