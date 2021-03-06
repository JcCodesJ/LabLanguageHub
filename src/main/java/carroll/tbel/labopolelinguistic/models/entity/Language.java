package carroll.tbel.labopolelinguistic.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Languages")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Language {

    @Id
    @Column(name = "Language Id", nullable = false)
    //Will be done in abbreviations (ex. fr1, en1, it1)
    private String langId;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private List<Business> business;

}
