package api.fuelTracker.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.OK)
public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String registration_number) {
        super("Could not find vehicle with registration number "+ registration_number);
    }
}
