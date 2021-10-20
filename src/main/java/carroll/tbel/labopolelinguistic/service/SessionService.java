package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.models.entity.User;
import carroll.tbel.labopolelinguistic.models.forms.LoginForm;
import carroll.tbel.labopolelinguistic.repository.UserRepository;
import carroll.tbel.labopolelinguistic.security.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final UserRepository uRep;
    private final AuthenticationManager auth;
    private final JwtProvider jwtProvider;

    public SessionService(UserRepository uRep, AuthenticationManager auth, JwtProvider jwtProvider) {
        this.uRep = uRep;
        this.auth = auth;
        this.jwtProvider = jwtProvider;
    }

    public String login(LoginForm form){

        User user = uRep.findByUsername(form.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("The username was not found") );
        //create auth
        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        //test auth
        auth.authenticate(authentication);
        //if ok, create and send token
        return jwtProvider.createToken(user.getUsername(), user.getRoles());

    }

}
