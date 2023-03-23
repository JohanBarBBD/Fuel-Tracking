package api.fuelTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.fuelTracker.exceptions.RecordsNotFoundException;
import api.fuelTracker.models.Record;
import api.fuelTracker.models.Vehicle;
import api.fuelTracker.repository.RecordsRepository;

@Service
public class RecordsService {
    @Autowired
    RecordsRepository recordsRepository;
    @Autowired
    VehiclesService vehiclesService; 

    public List<Record> getVehicleRecords(String apiKey, String regNumber) {
        Vehicle vehicle = vehiclesService.retrieveUserVehicleByRegistrationNumber(apiKey, regNumber);

        List<Record> records = recordsRepository.findByVehicleId(vehicle.getId());

        if (records.isEmpty()) {
            throw new RecordsNotFoundException("Records for vehicle with registration number "+ regNumber + "not found");
        }
        else {
            return records;
        }
    }

    public Record addRecord(String apiKey, String registrationNumber, Record newRecord) {
        Vehicle vehicle = vehiclesService.retrieveUserVehicleByRegistrationNumber(apiKey, registrationNumber);

        newRecord.setVehicleId(vehicle.getId());
        recordsRepository.save(newRecord);
        return newRecord;
    }
}
