package api.fuelTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.exceptions.AccessNotFoundException;
import api.fuelTracker.exceptions.AlreadyExistsException;
import api.fuelTracker.models.Access;
import api.fuelTracker.repository.AccessRepositry;

@Service
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

    public Access getAccess(String email) {
        List<Access> accessObject = accessRepositry.findByEmail(email);

        if (accessObject.isEmpty()) {
            throw new AccessNotFoundException("User with email address "+ email + "does not exist.");
        }
        else {
            return accessObject.get(0);
        }
    }
}
