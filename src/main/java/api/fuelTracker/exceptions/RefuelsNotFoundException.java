package api.fuelTracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class RefuelsNotFoundException extends RuntimeException {
    public RefuelsNotFoundException(String exception) {
        super(exception);
    }
}
