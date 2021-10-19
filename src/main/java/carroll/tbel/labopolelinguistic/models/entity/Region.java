package carroll.tbel.labopolelinguistic.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "region")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @Column(name = "region id", nullable = false)
    private String regionId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Country country;

}
