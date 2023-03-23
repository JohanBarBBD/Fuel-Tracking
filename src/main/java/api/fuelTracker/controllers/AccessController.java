package api.fuelTracker.controllers;

import java.sql.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.fuelTracker.dto.responses.Response;
import api.fuelTracker.models.Access;
import api.fuelTracker.services.AccessService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/access")
public class AccessController {
    @Autowired
    private AccessService accessService;

    @GetMapping(value="/{email}")
    public Response getAccessByEmail(@PathVariable("email") String email) {
        return Response
                .ok()
                .setPayload(accessService.getAccess(email));
    }
    
    @PostMapping(value = "/new")
    public Response createAccess(@RequestBody Map<String, String> email) {
        return Response
                .ok()
                .setPayload(accessService.addNewAccess(createAccessObject(email.get("email"))));
    }

    private Access createAccessObject(String email){
        return new Access()
                    .setApiKey(generateApiKey())
                    .setEmail(email)
                    .setValidityUntil(new Date(System.currentTimeMillis()));
    }

    private String generateApiKey() {
        String characters = "abcdefghijklmnopqrstuvwqyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String apiKey = "";
        Random rd = new Random();
        for (int i = 0; i < 12; i++) {
            apiKey += characters.charAt(rd.nextInt(characters.length()));
        }

        return apiKey;
    }
}
