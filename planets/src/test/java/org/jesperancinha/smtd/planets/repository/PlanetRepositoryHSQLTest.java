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
import static org.springframework.boot.jdbc.EmbeddedDatabaseConnection.HSQL;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED;

@DataJpaTest
@MockBean(Planet.class)
@AutoConfigureTestDatabase(replace= AUTO_CONFIGURED, connection = HSQL)
public class PlanetRepositoryHSQLTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSourceOriginWhenQueryThenHSQL() throws SQLException {
        final var shortConnectionString = dataSource.getConnection().toString();
        ConsolerizerComposer.outSpace()
                .magenta(shortConnectionString);

        assertThat(shortConnectionString).contains("org.hsqldb.jdbc.JDBCConnection");
    }
}