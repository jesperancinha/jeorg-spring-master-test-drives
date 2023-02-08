package org.jesperancinha.smtd.planets.repository

import com.ninjasquad.springmockk.MockkBean
import io.kotest.matchers.string.shouldContain
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.planets.dto.Planet
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.sql.SQLException
import javax.sql.DataSource

@DataJpaTest
@MockkBean(Planet::class)
class PlanetRepositoryDefaultKotlinTest(
    @Autowired
    private val dataSource: DataSource
) {

    /**
     * In our example, the default database is h2. But his is because that's the database we have configured in our [DataSource] for our production application
     *
     * @throws SQLException Connection Failure
     */
    @Test
    @Throws(SQLException::class)
    fun testDataSourceOriginWhenQueryThenH2() {
        val shortConnectionString = dataSource.connection.toString()
        ConsolerizerComposer.outSpace()
            .magenta(shortConnectionString)
        shortConnectionString.shouldContain("jdbc:h2:mem")
    }
}