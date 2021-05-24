package org.jesperancinha.smtd.carparts;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.carparts.model.cassandra.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Objects;

import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

@EnableTransactionManagement
@EnableWebSecurity
@EnableJpaRepositories
@SpringBootApplication
@EnableCassandraRepositories
public class CarPartsLauncher implements ApplicationRunner {

    private final CassandraTemplate cassandraTemplate;

    public CarPartsLauncher(
            @Autowired(required = false)
                    CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(CarPartsLauncher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        if (Objects.nonNull(cassandraTemplate)) {
            final var transmission = cassandraTemplate.insert(Part.builder().id(1L).name("transmission").build());

            ConsolerizerComposer.outSpace()
                    .blue(title("Welcome to project car-parts"))
                    .orange("We have just tried to insert a part in our cassandra database via a cassandra template")
                    .orange("This is it:")
                    .orange(transmission)
                    .orange("or")
                    .jsonPrettyPrint(transmission)
                    .reset();

            cassandraTemplate.truncate(Part.class);
        }
    }
}
