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
    private Integer refuel_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private Date refuel_date;

    private float refuel_amount;

    private float odometer_reading;

    private float cost;
}
