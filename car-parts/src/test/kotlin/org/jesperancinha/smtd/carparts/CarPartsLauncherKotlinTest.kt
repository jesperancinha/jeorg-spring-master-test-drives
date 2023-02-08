package org.jesperancinha.smtd.carparts

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.carparts.configuration.PartWebSecurity
import org.jesperancinha.smtd.carparts.controller.PartController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.context.annotation.Import

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Import(
    PartWebSecurity::class
)
class CarPartsLauncherKotlinTest(
    @Autowired
    private val partController: PartController
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
    }
}