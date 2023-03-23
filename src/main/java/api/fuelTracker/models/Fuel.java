package api.fuelTracker.models;

import java.util.Set;
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
@Table(name = "Fuels")
public class Fuel {
    @Id
    @Column(name = "fuel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fuel_id;

    private String fuel_type;

    @OneToMany(mappedBy = "fuel_price_id", cascade = CascadeType.ALL)
    private Set<FuelPrice> fuelPrices;
}