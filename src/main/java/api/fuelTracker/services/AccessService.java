package api.fuelTracker.services;

import org.springframework.beans.factory.annotation.Autowired;

import api.fuelTracker.exceptions.AccessNotFoundException;
import api.fuelTracker.exceptions.AlreadyExistsException;
import api.fuelTracker.models.Access;
import api.fuelTracker.repository.AccessRepositry;

public class AccessService {
    @Autowired
    private AccessRepositry accessRepositry;

    public Access addNewAccess(Access access){
        if (!accessRepositry.findByEmail(access.getEmail()).isEmpty()) {
            throw new AlreadyExistsException("User already exists");
        }
        else {
            accessRepositry.save(access);
            return access;
        }
    }

    public boolean removAccess(Access access) {
        if (!accessRepositry.findByEmail(access.getEmail()).isEmpty()) {
            throw new AccessNotFoundException("User does not exist");
        } else {
            accessRepositry.delete(access);
            return true;
        }
    }
}
