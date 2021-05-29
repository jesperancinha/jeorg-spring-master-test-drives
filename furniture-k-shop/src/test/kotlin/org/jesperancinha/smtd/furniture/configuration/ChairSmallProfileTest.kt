package org.jesperancinha.smtd.furniture.configuration

import org.assertj.core.api.Assertions.assertThat
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.furniture.model.Chair
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [ChairProfileConfiguration::class])
@ActiveProfiles("small")
open class ChairSmallProfileTest
constructor(@Autowired(required = false) chairBigSmally: Chair?) {

    private val chairBigSmall = chairBigSmally

    @Test
    fun testBeanExistsWhenProfileBigAndSmallThenNull() {
        ConsolerizerComposer.outSpace()
            .green()
            .jsonPrettyPrint(chairBigSmall)
            .reset()
        assertThat(chairBigSmall).isNull()
    }
}