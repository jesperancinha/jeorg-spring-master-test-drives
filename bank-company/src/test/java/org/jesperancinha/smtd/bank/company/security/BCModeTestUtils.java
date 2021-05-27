package org.jesperancinha.smtd.bank.company.security;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

import java.util.Objects;

public class BCModeTestUtils {
    public static void initializeTest(String strategyName) {
        SecurityContextHolder.setStrategyName(strategyName);
        SecurityContextHolder.setContext(createContext("clerk", "1234"));
    }

    public static void principalTestResult(Object principal) {
        ConsolerizerComposer.outSpace()
                .magenta("The resulting principal is %s.", principal)
                .newLine()
                .reset();
    }

    public static void principalCompletion(Object principal) {
        ConsolerizerComposer.outSpace()
                .green("Principal %s is done!", principal)
                .newLine()
                .reset();
    }

    public static void currentStatus(SecurityContext securityContext) {
        final var authentication = securityContext.getAuthentication();
        ConsolerizerComposer.outSpace()
                .none()
                .green("Current tread is %s", Thread.currentThread().getName())
                .blue(" and principal is %s", Objects.isNull(authentication) ? null : authentication.getPrincipal())
                .newLine()
                .reset();
    }

    public static SecurityContext createContext(String username, String password) {
        ConsolerizerComposer.outSpace()
                .none()
                .green("Security Context created with username %s and password %s", username, password)
                .newLine()
                .reset();
        SecurityContextImpl sc = new SecurityContextImpl();
        sc.setAuthentication(new UsernamePasswordAuthenticationToken(username, password));
        return sc;
    }
}
