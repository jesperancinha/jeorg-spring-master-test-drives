package org.jesperancinha.smtd.bank.company.security;

import jakarta.annotation.PostConstruct;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class BankCompanySecurity {

    @PostConstruct
    public void checkSecurityStrategy() {
        ConsolerizerComposer.outSpace()
                .none()
                .red("Security context holder strategy is").orange(SecurityContextHolder.getContextHolderStrategy())
                .newLine()
                .reset();
    }
}