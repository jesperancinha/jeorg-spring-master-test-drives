package org.jesperancinha.smtd.bank.company;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT,
        properties = {
                "environment=Great👍",
                "spring.config.location=classpath:/bank.properties"
        })
public class BankCompanyLauncherOtherPropertiesTest {

    /**
     * Properties and environment variables
     */
    @Value("${environment}")
    private String environment;

    @Value("${jeorg.bank.banking}")
    private String banking;

    @Value("${jeorg.bank.customer}")
    private String customer;

    @Test
    public void contextLoads() {
        assertThat(banking).isNotNull();
        assertThat(customer).isNotNull();
        ConsolerizerComposer.outSpace()
                .none()
                .cyan(environment)
                .newLine()
                .magenta("Banking is:")
                .red(banking)
                .magenta("!")
                .newLine()
                .magenta("Customer is:")
                .red(customer)
                .magenta("!")
                .reset();
    }
}