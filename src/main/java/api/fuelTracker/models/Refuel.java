package api.fuelTracker.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Data
@Entity
@Table(name = "Refuels")
public class Refuel {
    @Id
    @Column(name = "refuel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vehicle_id")
    private int vehicleId;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    // private Vehicle vehicle;

    @Column(name = "refuel_date")
    private Date refuelDate;

    @Column(name = "refuel_amount")
    private float refuelAmount;

    @Column(name = "odometer_reading")
    private float odometerReading;

    private float cost;
}
