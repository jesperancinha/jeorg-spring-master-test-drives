package org.jesperancinha.smtd.planets.repository;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.planets.dto.Planet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@MockBean(Planet.class)
public class PlanetRepositoryDefaultTest {

    @Autowired
    private DataSource dataSource;

    /**
     * In our example, the default database is h2. But his is because that's the database we have configured in our {@link DataSource} for our production application
     *
     * @throws SQLException Connection Failure
     */
    @Test
    public void testDataSourceOriginWhenQueryThenH2() throws SQLException {
        final var shortConnectionString = dataSource.getConnection().toString();
        ConsolerizerComposer.outSpace()
                .magenta(shortConnectionString);

        assertThat(shortConnectionString).contains("jdbc:h2:mem");
    }
}