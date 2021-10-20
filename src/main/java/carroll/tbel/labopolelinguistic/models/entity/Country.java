package carroll.tbel.labopolelinguistic.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @Column(name = "country id", nullable = false)
    //Continent names include Asia, Europe, North America, South America, Africa, Australia, Antarctica
    private String countryId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String continent;

    @OneToMany(mappedBy = "country")
    private List<Region> region;
}
