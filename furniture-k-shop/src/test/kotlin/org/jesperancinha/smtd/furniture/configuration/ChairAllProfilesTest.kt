package org.jesperancinha.smtd.furniture.configuration

import org.assertj.core.api.Assertions.assertThat
import org.jesperancinha.smtd.furniture.model.Chair
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [ChairProfileConfiguration::class])
@ActiveProfiles("big","small")
class ChairAllProfilesTest(
    @Autowired(required = false)
    val chairBigSmall:Chair?
) {

    @Test
    fun testBeanExistsWhenProfileBigAndSmallThenNull(){
        assertThat(chairBigSmall).isNotNull
        assertThat(chairBigSmall?.id).isEqualTo(124L)
        assertThat(chairBigSmall?.weight).isEqualTo(100L)
        assertThat(chairBigSmall?.designation).isEqualTo("arm chair")
    }
}