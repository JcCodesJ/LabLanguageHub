package carroll.tbel.labopolelinguistic.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "business")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Business {

    @Id
    @Column(name = "business id", nullable = false)
    private String businessId;
    @Column(nullable = false)
    private String typeBusiness;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;

    @ManyToOne
    private City city;

}
