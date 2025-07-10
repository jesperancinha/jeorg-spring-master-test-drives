package org.jesperancinha.smtd.carparts

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.smtd.carparts.MarkedUtils.getPartWithANullField
import org.jesperancinha.smtd.carparts.controller.PartController
import org.jesperancinha.smtd.carparts.model.jpa.Part
import org.jesperancinha.smtd.carparts.repos.PartRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.jdbc.Sql
import kotlin.reflect.full.declaredMemberProperties

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:schema.sql", "classpath:data.sql")
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
    }

    @Test
    fun `should get a null value even though it shouldn't be null`() {
        partRepository.findById(1).get().shouldNotBeNull().should {
            it.shouldNotBeNull().id shouldBe 1L
            val name: String = it.shouldNotBeNull().name
            name.shouldBeNull()
            changeName(name)
            val partWithANullField = getPartWithANullField()
            changeName(partWithANullField.name)
        }
    }

    private fun changeName(name: String) {
        Part::class.declaredMemberProperties.forEach {
            println("Field $it isMarkedNullable=${it.returnType.isMarkedNullable}")
        }
        println("This name is: $name. It shouldn't but it is null!")
        println(
            "And this is not a \"null\" string, it is actually a null value right? ${
                name.shouldBeNull().run { true }
            }"
        )
    }
}
