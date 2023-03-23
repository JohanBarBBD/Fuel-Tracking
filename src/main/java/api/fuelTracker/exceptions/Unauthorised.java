package api.fuelTracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class Unauthorised extends RuntimeException {
    public Unauthorised() {
        super("Unauthorised access!");
    }
}
