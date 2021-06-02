package org.jesperancinha.smtd.the.vault.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
open class TheVaultSecurityAdapter : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
            ?.mvcMatchers(HttpMethod.GET, "/vault/silver/**")?.hasAuthority("KEEPER")
            ?.mvcMatchers(HttpMethod.GET, "/vault/silver/**")?.hasRole("KEEPER")
            ?.mvcMatchers(HttpMethod.GET, "/vault/silver/test")?.permitAll()
            ?.and()
            ?.httpBasic()
            ?.and()
            ?.formLogin()
    }

    @Throws(Exception::class)
    override fun configure(builder: AuthenticationManagerBuilder) {
        builder.inMemoryAuthentication()
            .withUser("keeper_role").password("{noop}keeper_role").roles("KEEPER")
            .and()
            .withUser("keeper_auth").password("{noop}keeper_auth").authorities("KEEPER")
    }
}