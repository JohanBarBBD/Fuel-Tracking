package api.fuelTracker.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "Fuels")
public class Fuel {
    @Id
    @Column(name = "fuel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fuel_id;

    private Date start_date;

    private Date end_date;

    private String fuel_type;

    private float price_per_litre;
}