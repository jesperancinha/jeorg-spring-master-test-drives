package org.jesperancinha.smtd.carparts.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author jofisaes
 */
@Configuration
@Profile("prod")
public class PartWebSecurityProd {

    /**
     * Creates the security configuration.
     * In this case we configure our actuator to be protected in the prod profile
     *
     * @param http HttpSecurity configuration {@link HttpSecurity}
     * @throws Exception {@link Exception} If anything goes wrong while configuring security
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .requestMatchers("/actuator**")
                .authenticated()
                .and()
                .authorizeRequests()
                .requestMatchers("/**")
                .permitAll()
                .and()
                .formLogin()
                .and()
                .csrf().disable().build();
    }
}
