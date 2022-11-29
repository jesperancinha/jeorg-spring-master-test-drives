package org.jesperancinha.smtd.bank.company.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class BankCompanyWebConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .requestMatchers("/**")
                .permitAll()
                .and()
                .csrf().disable().build();
    }
}
