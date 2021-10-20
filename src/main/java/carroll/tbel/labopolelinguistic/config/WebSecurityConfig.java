package carroll.tbel.labopolelinguistic.config;

import carroll.tbel.labopolelinguistic.security.JwtAuthorizationFilter;
import carroll.tbel.labopolelinguistic.security.JwtProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtProvider provider;
    private final UserDetailsService service;

    public WebSecurityConfig(JwtProvider provider, UserDetailsService service) {
        this.provider = provider;
        this.service = service;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                //for businesses
                .antMatchers(HttpMethod.GET, "/business/**").hasAuthority("USER")
                .antMatchers("/business/**").hasAuthority("ADMIN")
                //for clients
                .antMatchers(HttpMethod.GET, "/language/**").hasAuthority("USER")
                .antMatchers("/language/**").hasAuthority("ADMIN")
                //for users
                .antMatchers("/user/**").hasAuthority("ADMIN")
                //for everything else
                .anyRequest().permitAll();

        http.addFilterBefore( new JwtAuthorizationFilter(provider), UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        //for H2
        http.headers()
                .frameOptions()
                .disable();
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

}
