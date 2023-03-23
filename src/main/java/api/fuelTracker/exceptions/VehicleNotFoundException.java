package api.fuelTracker.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String registration_number) {
        super("Could not find vehicle with registration number "+ registration_number);
    }
}
