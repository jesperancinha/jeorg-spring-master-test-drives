package org.jesperancinha.smtd.bank.company;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.bank.company.configuration.BankCompanyTestOnlyConfiguraton;
import org.jesperancinha.smtd.bank.company.repository.BankCompanyUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Since
 */
@SpringBootTest(webEnvironment = RANDOM_PORT,
        properties = "environment=Great👍")
@ActiveProfiles("test")
@ContextConfiguration(classes = BankCompanyTestOnlyConfiguraton.class)
public class BankCompanyLauncherTest {

    /**
     * Properties and environment variables
     */
    @Value("${environment}")
    private String environment;

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private DefaultListableBeanFactory defaultListableBeanFactory;

    @Autowired
    private BankCompanyTestOnlyConfiguraton bankCompanyTestOnlyConfiguraton;

    @Test
    public void contextLoads() {
        final var bankCompanyUserRepository = (BankCompanyUserRepository) beanFactory.getBean("bankCompanyUserRepository");
        ConsolerizerComposer.outSpace()
                .green("bankCompanyUserRepository")
                .black()
                .bgGreen(bankCompanyUserRepository)
                .reset();
        defaultListableBeanFactory.registerBeanDefinition("myBean", new GenericBeanDefinition());
        ConsolerizerComposer.outSpace()
                .green("bankCompanyUserRepository")
                .black()
                .bgGreen(bankCompanyUserRepository)
                .reset();
        BankCompanyLauncher.main(new String[0]);
        ConsolerizerComposer.outSpace()
                .cyan(environment)
                .newLine()
                .reset();

        ConsolerizerComposer.outSpace()
                .cyan("We do get the test variable value")
                .blue(bankCompanyTestOnlyConfiguraton.getValue())
                .cyan("And we can also get variable names in production")
                .blue(bankCompanyTestOnlyConfiguraton.getAppName())
                .magenta("@TestConfiguration Does not get auto-scanned")
                .reset();
    }
}