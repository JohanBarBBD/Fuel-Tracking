package api.fuelTracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccessNotFoundException extends RuntimeException {
    public AccessNotFoundException(String exception) {
        super(exception);
    }
}
