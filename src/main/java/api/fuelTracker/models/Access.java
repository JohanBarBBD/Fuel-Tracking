package api.fuelTracker.models;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Data
@Entity
@Table(name = "Access")
public class Access {
    @Id
    @Column(name = "access_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accessId;

    private String email;

    private String apiKey;

    private Date validityUntil;
}
