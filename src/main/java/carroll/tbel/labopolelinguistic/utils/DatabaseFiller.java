package carroll.tbel.labopolelinguistic.utils;

import carroll.tbel.labopolelinguistic.models.entity.User;
import carroll.tbel.labopolelinguistic.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseFiller implements InitializingBean {

    private final UserRepository uRep;
    private final PasswordEncoder encoder;

    public DatabaseFiller(UserRepository uRep, PasswordEncoder encoder) {
        this.uRep = uRep;
        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        User user = new User();

        user.setUsername("USER");
        user.setPassword(encoder.encode("pass") );

        user.setRoles(List.of("USER") );

        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);

        User admin = new User();

        admin.setUsername("ADMIN");
        admin.setPassword( encoder.encode("pass") );

        admin.setRoles( List.of("ADMIN","USER") );

        admin.setEnabled(true);
        admin.setAccountNonLocked(true);
        admin.setAccountNonExpired(true);
        admin.setCredentialsNonExpired(true);

        uRep.save(user);
        uRep.save(admin);

    }
}
