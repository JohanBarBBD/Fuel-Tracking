package api.fuelTracker.services;

import java.util.List;
import java.util.Random;

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
    private Random rd = new Random();

    public Access addNewAccess(Access access){
        if (!accessRepositry.findByEmail(access.getEmail()).isEmpty()) {
            throw new AlreadyExistsException("User already exists");
        }
        else {
            access.setApiKey(generateApiKey());
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

    private String generateApiKey() {
        String characters = "abcdefghijklmnopqrstuvwqyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String apiKey = "";
        for (int i = 0; i < 12; i++) {
            apiKey += characters.charAt(rd.nextInt(characters.length()));
        }

        return apiKey;
    }
}
