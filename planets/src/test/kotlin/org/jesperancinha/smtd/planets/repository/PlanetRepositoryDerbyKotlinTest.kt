package org.jesperancinha.smtd.planets.repository

import com.ninjasquad.springmockk.MockkBean
import io.kotest.matchers.string.shouldContain
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.planets.dto.Planet
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.sql.SQLException
import javax.sql.DataSource

@DataJpaTest
@MockkBean(Planet::class)
@AutoConfigureTestDatabase(
    replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED,
    connection = EmbeddedDatabaseConnection.DERBY
)
class PlanetRepositoryDerbyKotlinTest(
    @Autowired
    private val dataSource: DataSource
) {

    @Test
    @Throws(SQLException::class)
    fun testDataSourceOriginWhenQueryThenDerby() {
        val shortConnectionString = dataSource.connection.toString()
        ConsolerizerComposer.outSpace()
            .magenta(shortConnectionString)
        shortConnectionString.shouldContain("org.apache.derby.impl.jdbc.EmbedConnection")
    }
}