package org.jesperancinha.smtd.carparts.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class PartWebSecurity extends WebSecurityConfigurerAdapter {


    /**
     * Creates the security configuration.
     *
     * @param http HttpSecurity configuration {@link HttpSecurity}
     * @throws Exception {@link Exception} If anything goes wrong while configuring security
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .and()
                .csrf().disable();
    }
}
