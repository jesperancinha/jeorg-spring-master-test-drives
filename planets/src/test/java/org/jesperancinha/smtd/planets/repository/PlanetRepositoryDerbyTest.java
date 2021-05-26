package org.jesperancinha.smtd.planets.repository;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.smtd.planets.dto.Planet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@MockBean(Planet.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED, connection = EmbeddedDatabaseConnection.DERBY)
public class PlanetRepositoryDerbyTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSourceOriginWhenQueryThenDerby() throws SQLException {
        final var shortConnectionString = dataSource.getConnection().toString();
        ConsolerizerComposer.outSpace()
                .magenta(shortConnectionString);

        assertThat(shortConnectionString).contains("org.apache.derby.impl.jdbc.EmbedConnection");
    }
}