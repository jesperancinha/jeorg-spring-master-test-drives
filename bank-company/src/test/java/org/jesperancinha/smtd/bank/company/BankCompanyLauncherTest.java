package org.jesperancinha.smtd.bank.company;

import jakarta.inject.Named;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.bank.company.configuration.BankCompanyTestOnlyConfiguration;
import org.jesperancinha.smtd.bank.company.model.Bank;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Since
 */
@SpringBootTest(webEnvironment = RANDOM_PORT,
        properties = "environment=Great👍")
@ActiveProfiles("test")
@ContextConfiguration(classes = BankCompanyTestOnlyConfiguration.class)
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
    private BankCompanyTestOnlyConfiguration bankCompanyTestOnlyConfiguration;

    @Autowired
    @Named("bank1")
    private Bank bank;

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
        ConsolerizerComposer.outSpace()
                .cyan(environment)
                .newLine()
                .reset();

        ConsolerizerComposer.outSpace()
                .cyan("We do get the test variable value")
                .blue(bankCompanyTestOnlyConfiguration.getValue())
                .cyan("And we can also get variable names in production")
                .blue(bankCompanyTestOnlyConfiguration.getAppName())
                .magenta("@TestConfiguration Does not get auto-scanned")
                .reset();

        ConsolerizerComposer.outSpace()
                .red(bank)
                .reset();

        assertThat(bank.getName()).isEqualTo("Bank 1");
        defaultListableBeanFactory.destroySingleton("myBean");
    }
}