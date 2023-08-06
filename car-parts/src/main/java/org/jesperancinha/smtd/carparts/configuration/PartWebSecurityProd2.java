package org.jesperancinha.smtd.carparts.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("prod2")
public class PartWebSecurityProd2 {

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
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry
                                .requestMatchers("/actuator**")
                                .authenticated()
                                .requestMatchers("/**")
                                .permitAll()
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
