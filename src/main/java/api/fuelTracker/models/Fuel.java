package api.fuelTracker.models;

import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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

    private String fuel_type;

    @OneToMany(mappedBy = "Fuels", cascade = CascadeType.ALL)
    private Set<FuelPrice> fuelPrices;
}