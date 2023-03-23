package api.fuelTracker.controllers;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.fuelTracker.dto.responses.Response;
import api.fuelTracker.models.Refuel;
import api.fuelTracker.services.RefuelService;

@RestController
@RequestMapping("/refuel")
public class RefuelController {
    @Autowired
    private RefuelService refuelService;

    @PostMapping("/getByVehicleRegNumber")
    public Response<?> getRefuelByVehicleRegNumber(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(refuelService.getRefuelsByVehicleRegNumber(object.get("apiKey"),
                        object.get("registrationNumber")));
    }

    @PostMapping("/getUserRefuels")
    public Response<?> getUserRefuels(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(refuelService.getTotalRefuelsOfUser(object.get("apiKey")));
    }

    // Post
    @PostMapping(value = "/createRefuel", consumes = "application/json", produces = "application/json")
    public Response<?> addRefuel(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(refuelService.addRefuel(object.get("apiKey"), object.get("registrationNumber"),
                        createRefuelObject(object)));
    }

    private Refuel createRefuelObject(Map<String, String> object) {
        return new Refuel()

                .setVehicleId(Integer.parseInt(object.get("vehicleId")))
                .setRefuelDate(Date.valueOf(object.get("refuelDate")))
                .setRefuelAmount(Float.parseFloat(object.get("refuelAmount")))
                .setOdometerReading(Float.parseFloat(object.get("odometerReading")))
                .setCost(Float.parseFloat(object.get("cost")));

    }

    // delete
}
