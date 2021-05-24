package org.jesperancinha.smtd.carparts.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("prod1")
public class PartWebSecurityProd1 extends WebSecurityConfigurerAdapter {

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
                .antMatchers("/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/actuator**")
                .authenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable();
    }
}
