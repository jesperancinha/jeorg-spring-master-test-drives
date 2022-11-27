package org.jesperancinha.smtd.carparts.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("!prod && !prod1 && !prod2")
public class PartWebSecurity {

    /**
     * Creates the security configuration.
     *
     * @param http HttpSecurity configuration {@link HttpSecurity}
     * @throws Exception {@link Exception} If anything goes wrong while configuring security
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .requestMatchers("/**")
                .permitAll()
                .and()
                .csrf().disable().build();
    }
}
