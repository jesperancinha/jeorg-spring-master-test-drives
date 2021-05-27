package org.jesperancinha.smtd.bank.company;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.bank.company.repository.BankCompanyUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT,
        properties = "environment=Great👍")
public class BankCompanyLauncherTest {

    /**
     * Properties and environment variables
     */
    @Value("${environment}")
    private String environment;

    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void contextLoads() {
        final var bankCompanyUserRepository = (BankCompanyUserRepository) beanFactory.getBean("bankCompanyUserRepository");
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
    }
}