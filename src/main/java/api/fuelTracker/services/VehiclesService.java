package api.fuelTracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.repository.VehiclesRepository;

@Service
public class VehiclesService {
    @Autowired
    VehiclesRepository vehiclesRepository;
}
