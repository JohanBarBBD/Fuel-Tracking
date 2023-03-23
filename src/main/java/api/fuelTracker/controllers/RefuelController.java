package api.fuelTracker.controllers;

import io.swagger.annotations.Api;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

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
    @PostMapping(value = "/createRefuel", consumes = "application/json", produces = "application/json")
    public Response addRefuel(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(refuelService.addRefuel(object.get("apiKey"),createRefuelObject(object)));
    }
    @PostMapping(value = "/addRecord")
    public Response addRecord(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(createRefuelObject(object));
    }
    private Refuel createRefuelObject(Map<String, String> object) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return new Refuel()
        
                    .setVehicleId(Integer.parseInt(object.get("vehicleId")))
                    .setRefuelDate(Date.valueOf(object.get("refuelDate")))
                    .setRefuelAmount(Float.parseFloat(object.get("refuelAmount")))
                    .setOdometerReading(Float.parseFloat(object.get("odometerReading")))
                    .setCost(Float.parseFloat(object.get("cost")));                    

    }
    
    //delete
}
