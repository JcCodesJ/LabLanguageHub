package carroll.tbel.labopolelinguistic.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtAuthorizationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //Receive token
        String token = jwtProvider.resolveToken( request );
        //Verify if the token is valid
        if (token != null && jwtProvider.validate( token )){
            //if valid: register the user as authenticated and their role
            Authentication auth = jwtProvider.getAuth( token );
            SecurityContextHolder.getContext().setAuthentication( auth );
        }

        filterChain.doFilter( request, response );
    }

}
