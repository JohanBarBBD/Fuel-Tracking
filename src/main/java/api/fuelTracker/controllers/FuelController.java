package api.fuelTracker.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.fuelTracker.dto.responses.Response;
import api.fuelTracker.services.FuelService;

@RestController
@RequestMapping("/fuel")
@Api(value = "", description = "Details about fuels types and fuel prices")
public class FuelController {
    @Autowired
    private FuelService fuelService;

    @GetMapping("/fuelType")
    public Response getFuelType() {
        return Response
                .ok()
                .setPayload(fuelService.getFuelType(0));
    }

    // @GetMapping("/allFuelTypes")

    // @GetMapping("/currentFuelPrice")

    // @GetMapping("/futureFuelPrice")
}
