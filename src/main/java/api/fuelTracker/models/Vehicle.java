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
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "access_id")
    private Integer accessId;

    private String make;

    private String model;

    @Column(name = "reg")
    private String registrationNumber;

    @Column(name = "odometer")
    private float odometerReading;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_type")
    private Fuel fuel;

    @Column(name = "tank_size")
    private float tankSize;

    @Column(name = "km_per_litre")
    private float kmPerLitre;
}
