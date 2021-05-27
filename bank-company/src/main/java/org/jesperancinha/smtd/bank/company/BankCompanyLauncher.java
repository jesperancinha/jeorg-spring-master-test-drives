package org.jesperancinha.smtd.bank.company;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BankCompanyLauncher implements ApplicationRunner {

    @Value("#{ systemProperties['user.region'] }")
    private String region;

    @Value("#{ systemProperties['user.country'] }")
    private String country;

    @Value("#{'${jeorg.bank.salaries}'.split(',').?[new Integer(#this) > 10]}")
    private List<Long> salaries;

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private Long randomNumber;

    @Value("${jeorg.bank.salaries}")
    private String salariesString;

    @Value("#{'${jeorg.bank.salaries}'}")
    private String salariesString2;

    @Value("#{#root.toString()}")
    private String bankContextString;

    @Value("#{${jeorg.bank.dependencies}}")
    private Map<String, Long> bankDependencies;

    @Value("#{${jeorg.bank.salariesexplained}.?[#this>2]}")
    private List<Long> salariesexplained;

    private final ApplicationContext applicationContext;

    public BankCompanyLauncher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(BankCompanyLauncher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        ConsolerizerComposer.outSpace()
                .none()
                .yellow("Your bank is running in:")
                .green(region)
                .newLine()
                .yellow("And the country is:")
                .green(country)
                .newLine()
                .reset();

        List<Integer> primes = Arrays.asList(50000, 130000, 110000, 80000);

         final var parser = new SpelExpressionParser();
        final var context = new StandardEvaluationContext();
        context.setVariable("primes", primes);

       final var primesGreaterThanTen =
                (List<Integer>) parser.parseExpression("#primes.?[#this>50000]").getValue(context);

        ConsolerizerComposer.outSpace()
                .none()
                .blue(primesGreaterThanTen)
                .newLine()
                .reset();
        ConsolerizerComposer.outSpace()
                .none()
                .blue(salaries)
                .newLine()
                .reset();
        ConsolerizerComposer.outSpace()
                .none()
                .blue(salariesString2)
                .newLine()
                .reset();
        ConsolerizerComposer.outSpace()
                .none()
                .blue(randomNumber)
                .newLine()
                .reset();
        ConsolerizerComposer.outSpace()
                .none()
                .blue(salariesString)
                .newLine()
                .reset();
        ConsolerizerComposer.outSpace()
                .none()
                .blue(bankContextString)
                .newLine()
                .reset();
        ConsolerizerComposer.outSpace()
                .none()
                .blue(bankDependencies)
                .magenta(bankDependencies.get("olhao"))
                .magenta(bankDependencies.get("amsterdam"))
                .newLine()
                .reset();
        ConsolerizerComposer.outSpace()
                .none()
                .blue(salariesexplained)
                .magenta(salariesexplained.size())
                .newLine()
                .reset();

    }
}
