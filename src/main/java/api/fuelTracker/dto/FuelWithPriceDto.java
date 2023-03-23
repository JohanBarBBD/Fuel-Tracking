package api.fuelTracker.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class FuelWithPriceDto {
    private Integer fuelId;
    private String fuelType;
    private float currentPrice;
}
