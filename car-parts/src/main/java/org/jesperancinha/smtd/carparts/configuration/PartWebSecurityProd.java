package org.jesperancinha.smtd.carparts.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author jofisaes
 */
@Configuration
@Profile("prod")
public class PartWebSecurityProd extends WebSecurityConfigurerAdapter {

    /**
     * Creates the security configuration.
     * In this case we configure our actuator to be protected in the prod profile
     *
     * @param http HttpSecurity configuration {@link HttpSecurity}
     * @throws Exception {@link Exception} If anything goes wrong while configuring security
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/actuator**")
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .and()
                .formLogin()
                .and()
                .csrf().disable();
    }
}
