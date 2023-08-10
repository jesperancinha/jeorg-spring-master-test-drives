package org.jesperancinha.smtd.bank.company.security;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.smtd.bank.company.security.BCModeTestUtils.*;
import static org.springframework.security.core.context.SecurityContextHolder.MODE_THREADLOCAL;

@SpringBootTest
class BCModeModeThreadLocalSecurityTest {

    @BeforeEach
    public void setup() {
        final var securityContext = SecurityContextHolder.getContext();
        assertThat(securityContext).isNotNull();
        final var authentication = securityContext.getAuthentication();
        assertThat(authentication).isNull();
        initializeTest(MODE_THREADLOCAL);
    }

    @Test
    public void testModeThreadLocalWhenCreatingWithThreadLocalThenNewContextGetsUser() {
        final var securityContext = SecurityContextHolder.getContext();
        assertThat(securityContext).isNotNull();
        final var authentication = securityContext.getAuthentication();
        assertThat(authentication).isNotNull();
        final var principal = authentication.getPrincipal();
        assertThat(principal).isEqualTo("clerk");
        principalTestResult(principal);
    }

    @Test
    public void testMultiThreadModeThreadLocalWhenCreatingWithThreadLocalThenNoPrincipal() throws InterruptedException {
        final var principal = new AtomicReference<>();
        final var clerkThread = new Thread(() -> {
            principal.set(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            principalCompletion(principal);
        });
        clerkThread.start();
        clerkThread.join();

        assertThat(principal.get()).isNull();
    }

    @Test
    public void testMultiThreadPoolModeThreadLocalWhenCreatingWithThreadLocalThenNoPrincipal() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        final var principal = new AtomicReference<>();
        currentStatus(SecurityContextHolder.getContext());
        final var submit = executorService.submit(() -> {
            currentStatus(SecurityContextHolder.getContext());
            final var authentication = SecurityContextHolder.getContext().getAuthentication();
            principal.set(Objects.isNull(authentication) ? null : authentication.getPrincipal());
            principalCompletion(principal);
            return true;
        });
        final boolean done = submit.get();

        assertThat(done).isTrue();
        assertThat(principal.get()).isNull();

        SecurityContextHolder.setContext(createContext("janitor", "1234"));
        currentStatus(SecurityContextHolder.getContext());
        executorService.execute(() -> {
            currentStatus(SecurityContextHolder.getContext());
            principal.set(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            principalCompletion(principal);
        });
        executorService.shutdown();
        final boolean done2 = executorService.awaitTermination(1, TimeUnit.SECONDS);

        assertThat(done2).isTrue();
        assertThat(principal.get()).isNull();
    }


    @Test
    public void testMultiThreadPooWithDelegatorlModeThreadLocalWhenCreatingWithThreadLocalThenNoPrincipal() throws InterruptedException, ExecutionException {
        final var executorService = Executors.newSingleThreadExecutor();
        final var delegatingSecurityContextExecutorService = new DelegatingSecurityContextExecutorService(executorService);
        final var principal = new AtomicReference<>();
        currentStatus(SecurityContextHolder.getContext());
        final var submit = delegatingSecurityContextExecutorService.submit(() -> {
            currentStatus(SecurityContextHolder.getContext());
            principal.set(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            principalCompletion(principal);
            return true;
        });
        final boolean done1 = submit.get();

        assertThat(done1).isTrue();
        assertThat(principal.get()).isEqualTo("clerk");

        SecurityContextHolder.setContext(createContext("janitor", "1234"));
        currentStatus(SecurityContextHolder.getContext());
        delegatingSecurityContextExecutorService.execute(() -> {
            currentStatus(SecurityContextHolder.getContext());
            principal.set(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            principalCompletion(principal);
        });
        delegatingSecurityContextExecutorService.shutdown();
        final boolean done2 = delegatingSecurityContextExecutorService.awaitTermination(1, TimeUnit.SECONDS);

        assertThat(done2).isTrue();
        assertThat(principal.get()).isEqualTo("janitor");
        principalTestResult(principal);
    }

    @AfterEach
    public void tearDown() {
        initializationCount();
    }
}