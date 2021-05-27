package org.jesperancinha.smtd.bank.company.security;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;

import javax.annotation.PostConstruct;

@Configuration
public class BankCompanySecurity {

    @PostConstruct
    public void enableAuthCtxOnSpawnedThreads() {
        ConsolerizerComposer.outSpace()
                .none()
                .red("Security context holder strategy is").orange(SecurityContextHolder.getContextHolderStrategy())
                .newLine()
                .reset();
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_GLOBAL);
        final SecurityContextHolderStrategy contextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
        final SecurityContext securityContext = contextHolderStrategy.getContext();
        ConsolerizerComposer.outSpace()
                .none()
                .red("Security context holder strategy is").orange(contextHolderStrategy)
                .newLine()
                .red("Security context is").orange(securityContext)
                .newLine()
                .red("Authentication  is").orange(securityContext.getAuthentication())
                .newLine()
                .reset();
    }
}