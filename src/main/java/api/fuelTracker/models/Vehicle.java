package api.fuelTracker.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Data
@Entity
@Table(name = "Vehicles")
public class Vehicle {
    @Id
    @Column(name = "vehicles_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer accessId;

    private String make;

    private String model;

    private String registrationNumber;

    private float odometerReading;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_type")
    private Fuel fuel;

    private float tankSize;

    private float kmPerLiter;
}
