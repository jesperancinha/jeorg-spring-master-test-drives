package org.jesperancinha.smtd.bank.company.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:test.properties",
                encoding = "UTF-8"),
        @PropertySource(value = "classpath:customer.properties",
                encoding = "UTF-8"),
        @PropertySource(value = "classpath:${spring.datasource.username}.properties",
                encoding = "UTF-8")
})
public class BankCompanyTestConfiguration {
}
