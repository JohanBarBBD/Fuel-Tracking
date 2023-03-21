package api.fuelTracker.models;

import javax.persistence.*;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Vehicles")
public class Vehicles {
    @Id
    @Column(name = "vehicles_id")
    private int id;

    private int accessId;

    private String make;

    private String model;

    private String registrationNumber;

    private float odometerReading;

    private String fuelType;

    private float tankSize;

    private float kmPerLiter;
}
