package carroll.tbel.labopolelinguistic.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String fName;
    @Column(nullable = false)
    private String lName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String emailAddress;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @Column(nullable = false)
    private boolean accountNonExpired = true;
    @Column(nullable = false)
    private boolean accountNonLocked = true;
    @Column(nullable = false)
    private boolean credentialsNonExpired = true;
    @Column(nullable = false)
    private boolean enabled = true;

    @ManyToMany
    private List<Language> language;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
