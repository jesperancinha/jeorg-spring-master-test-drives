package org.jesperancinha.smtd.bank.company.security

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference

@SpringBootTest
internal class BCModeModeThreadLocalSecurityKotlinTest {
    @BeforeEach
    fun setup() {
        val securityContext = SecurityContextHolder.getContext()
        Assertions.assertThat(securityContext).isNotNull
        val authentication = securityContext.authentication
        Assertions.assertThat(authentication).isNull()
        BCModeTestUtils.initializeTest(SecurityContextHolder.MODE_THREADLOCAL)
    }

    @Test
    fun testModeThreadLocalWhenCreatingWithThreadLocalThenNewContextGetsUser() {
        val securityContext = SecurityContextHolder.getContext()
        Assertions.assertThat(securityContext).isNotNull
        val authentication = securityContext.authentication
        Assertions.assertThat(authentication).isNotNull
        val principal = authentication.principal
        Assertions.assertThat(principal).isEqualTo("clerk")
        BCModeTestUtils.principalTestResult(principal)
    }

    @Test
    @Throws(InterruptedException::class)
    fun testMultiThreadModeThreadLocalWhenCreatingWithThreadLocalThenNoPrincipal() {
        val principal = AtomicReference<Any>()
        val clerkThread = Thread {
            principal.set(SecurityContextHolder.getContext().authentication.principal)
            BCModeTestUtils.principalCompletion(principal)
        }
        clerkThread.start()
        clerkThread.join()
        Assertions.assertThat(principal.get()).isNull()
    }

    @Test
    @Throws(InterruptedException::class, ExecutionException::class)
    fun testMultiThreadPoolModeThreadLocalWhenCreatingWithThreadLocalThenNoPrincipal() {
        val executorService = Executors.newSingleThreadExecutor()
        val principal = AtomicReference<Any?>()
        BCModeTestUtils.currentStatus(SecurityContextHolder.getContext())
        val submit = executorService.submit<Boolean> {
            BCModeTestUtils.currentStatus(SecurityContextHolder.getContext())
            val authentication = SecurityContextHolder.getContext().authentication
            principal.set(if (Objects.isNull(authentication)) null else authentication.principal)
            BCModeTestUtils.principalCompletion(principal)
            true
        }
        val done = submit.get()
        Assertions.assertThat(done).isTrue
        Assertions.assertThat(principal.get()).isNull()
        SecurityContextHolder.setContext(BCModeTestUtils.createContext("janitor", "1234"))
        BCModeTestUtils.currentStatus(SecurityContextHolder.getContext())
        executorService.execute {
            BCModeTestUtils.currentStatus(SecurityContextHolder.getContext())
            principal.set(SecurityContextHolder.getContext().authentication.principal)
            BCModeTestUtils.principalCompletion(principal)
        }
        executorService.shutdown()
        val done2 = executorService.awaitTermination(1, TimeUnit.SECONDS)
        Assertions.assertThat(done2).isTrue
        Assertions.assertThat(principal.get()).isNull()
    }

    @Test
    @Throws(InterruptedException::class, ExecutionException::class)
    fun testMultiThreadPooWithDelegatorlModeThreadLocalWhenCreatingWithThreadLocalThenNoPrincipal() {
        val executorService = Executors.newSingleThreadExecutor()
        val delegatingSecurityContextExecutorService = DelegatingSecurityContextExecutorService(executorService)
        val principal = AtomicReference<Any>()
        BCModeTestUtils.currentStatus(SecurityContextHolder.getContext())
        val submit = delegatingSecurityContextExecutorService.submit<Boolean> {
            BCModeTestUtils.currentStatus(SecurityContextHolder.getContext())
            principal.set(SecurityContextHolder.getContext().authentication.principal)
            BCModeTestUtils.principalCompletion(principal)
            true
        }
        val done1 = submit.get()
        Assertions.assertThat(done1).isTrue
        Assertions.assertThat(principal.get()).isEqualTo("clerk")
        SecurityContextHolder.setContext(BCModeTestUtils.createContext("janitor", "1234"))
        BCModeTestUtils.currentStatus(SecurityContextHolder.getContext())
        delegatingSecurityContextExecutorService.execute {
            BCModeTestUtils.currentStatus(SecurityContextHolder.getContext())
            principal.set(SecurityContextHolder.getContext().authentication.principal)
            BCModeTestUtils.principalCompletion(principal)
        }
        delegatingSecurityContextExecutorService.shutdown()
        val done2 = delegatingSecurityContextExecutorService.awaitTermination(1, TimeUnit.SECONDS)
        Assertions.assertThat(done2).isTrue
        Assertions.assertThat(principal.get()).isEqualTo("janitor")
        BCModeTestUtils.principalTestResult(principal)
    }

    @AfterEach
    fun tearDown() {
        BCModeTestUtils.initializationCount()
    }
}