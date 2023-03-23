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
@Table(name = "Records")
public class Record {
    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer record_id;

    @Column(name = "vehicle_id")
    private int vehicleId;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    // private Vehicle vehicle;

    @Column(name = "record_date")
    private Date recordDate;

    @Column(name = "fuel_usage")
    private float fuelUsage;

    private float distance;
}
