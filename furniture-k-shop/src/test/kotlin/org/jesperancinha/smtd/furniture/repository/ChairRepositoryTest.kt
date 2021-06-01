package org.jesperancinha.smtd.furniture.repository

import org.assertj.core.api.Assertions.assertThat
import org.jesperancinha.smtd.furniture.configuration.CaseConfigurationTest
import org.jesperancinha.smtd.furniture.configuration.ChairConfigurationTest
import org.jesperancinha.smtd.furniture.model.Case
import org.jesperancinha.smtd.furniture.model.Chair
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.autoconfigure.health.HealthProperties
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.ContextHierarchy
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@MockBean(HealthProperties::class)
@ContextHierarchy(
    value = [
        ContextConfiguration(classes = [ChairConfigurationTest::class]),
        ContextConfiguration(classes = [CaseConfigurationTest::class])],
)
open class ChairRepositoryTest(
    @Autowired
    val chairList: MutableList<Chair>,
    @Autowired
    val caseList: MutableList<Case>
) {

    @Test
    @DirtiesContext(hierarchyMode = DirtiesContext.HierarchyMode.CURRENT_LEVEL)
    fun testChairRepository1() {
        caseList.add(
            Case(
                id = 0L,
                weight = 50L,
                designation = "Wood Case"
            )
        )
        caseList.add(
            Case(
                id = 0L,
                weight = 50L,
                designation = "Wood Case"
            )
        )
        chairList.add(
            Chair(
                id = 0L,
                weight = 125L,
                designation = "Wheelchair"
            )
        )
        assertThat(caseList).hasSize(2)
        assertThat(chairList).hasSize(1)
    }

    /**
     * The last element of the hierarchy is the {@link CaseConfigurationTest} configuration.
     * Therefore, CURRENT_LEVEL will trigger the dirties context to affect only the case collection.
     */
    @Test
    fun testChairRepository2() {
        assertThat(caseList).hasSize(0)
        assertThat(chairList).hasSize(1)
    }
}