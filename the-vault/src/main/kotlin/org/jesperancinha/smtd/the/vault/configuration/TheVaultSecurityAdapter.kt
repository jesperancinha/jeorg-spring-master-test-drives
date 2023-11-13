package org.jesperancinha.smtd.the.vault.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
open class TheVaultSecurityAdapter {

    @Bean
    open fun filterChain(http: HttpSecurity): SecurityFilterChain =
        http.authorizeHttpRequests {
            it.requestMatchers(HttpMethod.GET, "/vault/silver/**")
                .hasAuthority("KEEPER")
                .requestMatchers(HttpMethod.GET, "/vault/silver/**")
                .hasRole("KEEPER")
                .requestMatchers(HttpMethod.GET, "/vault/silver/test")
                .permitAll()
        }
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
            .build()
}
