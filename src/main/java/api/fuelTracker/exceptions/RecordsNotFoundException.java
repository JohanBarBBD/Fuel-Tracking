package api.fuelTracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class RecordsNotFoundException extends RuntimeException {
    public RecordsNotFoundException(String exception) {
        super(exception);
    }
}
