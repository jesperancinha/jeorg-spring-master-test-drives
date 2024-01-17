package org.jesperancinha.smtd.carparts

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.carparts.controller.PartController
import org.jesperancinha.smtd.carparts.repos.PartRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.jdbc.Sql

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:data.sql")
class CarPartsKotlinLauncherKotlinTest @Autowired constructor(
    val partController: PartController,
    val partRepository: PartRepository
) {

    @Test
    fun testContext() {
        ConsolerizerComposer.outSpace()
            .unicorns(100)
            .orange("Never Inject a Controller in production code!!!")
            .orange("This is just to show that we can Inject Controller, RestController or Component.")
            .orange("A RestController is also a Controller, which is also a Component.")
            .orange("This means that we can inject this:")
            .orange(partController)
            .jsonPrettyPrint(partController)
            .unicorns(100)
            .reset()

        partRepository.findByIdOrNull(1).should {
            it?.id shouldBe 1L
        }
    }
}