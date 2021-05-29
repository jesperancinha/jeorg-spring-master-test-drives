package org.jesperancinha.smtd.bank.company.configuration;

import lombok.Data;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.bank.company.model.Bank;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Using Configuration we get properties from both production and test
 * It does not get automatically scanned
 */
@Data
@Configuration
@Lazy
public class BankCompanyTestForLazyConfiguraton {

    @Bean
    public Bank bank() {
        ConsolerizerComposer.outSpace()
                .unicorns(100)
                .yellow("Bank has been initialized!")
                .unicorns(100)
                .reset();
        return new Bank();
    }
}
