package carroll.tbel.labopolelinguistic.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @Column(name = "cityId", nullable = false)
    //Will be either
    private String cityId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private long postCode;

    @ManyToOne
    private Region region;

}
