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
@Table(name = "FuelPrices")
public class FuelPrice {
    @Id
    @Column(name = "fuel_price_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fuel_price_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_id")
    private int Fuel;

    private Date start_date;

    private Date end_date;

    private float price_per_litre;
}
