package api.fuelTracker.controllers;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.fuelTracker.dto.responses.Response;
import api.fuelTracker.services.RecordsService;

import api.fuelTracker.models.Record;

@RestController
@RequestMapping("/records")
public class RecordsController {
    @Autowired
    private RecordsService recordsService;

    @PostMapping(value = "/getVehicleRecords")
    public Response<?> getVehicleRecords(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(recordsService.getVehicleRecords(object.get("apiKey"), object.get("registrationNumber")));
    }

    @PostMapping(value = "/addRecord")
    public Response<?> addRecord(@RequestBody Map<String, String> object) {
        return Response
                .ok()
                .setPayload(recordsService.addRecord(object.get("apiKey"),
                        object.get("registrationNumber"),
                        createRecordObject(object)));
    }

    private Record createRecordObject(Map<String, String> object) {
        return new Record()
                .setDistance(Float.parseFloat(object.get("distance")))
                .setFuelUsage(Float.parseFloat(object.get("fuelUsage")))
                .setRecordDate(new Date(System.currentTimeMillis()));
    }
}
